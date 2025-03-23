/*
 * The `Cart` class manages the shopping cart functionality, including:
 * - Adding items to the cart.
 * - Removing items from the cart.
 * - Checking out (processing payment, handling employee permissions).
 *
 * Cart is initialized in `main` **after** `IEmployeeSystem` is initialized and
 * the `login()` method is called to authenticate an `Employee`.
 * 
 * Employees can:
 * - View the total amount of the order.
 * - Process payments or cancel the order.
 * 
 * Managers (determined via `isManager()`) can:
 * - See the profit made by the business.
 * - Redeem points if the user is a member.
 */


package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cafe.Cafe;
import cafe.MenuItem;
import membership.Member;
import membership.MemberSignInUp;
import model.Employee;
import exceptions.CheckoutException;
import exceptions.TooManyInstanceException;


public class Cart {
    private enum CheckoutOptions {PAY, CANCEL}
    public static final String EXIT = "EXIT";
    private IEmployeeSystem es;
    private Scanner scanner;
    private Cafe cafe;
    private Employee employee;
    private List<MenuItem> cart;
    private ProfitCalculator calculator;

    public Cart(Cafe cafe, IEmployeeSystem es, Employee employee, Scanner scanner) {
        this.cafe = cafe;
        this.es = es;
        this.employee = employee;
        this.scanner = scanner;
        this.cart = new ArrayList<>();
        this.calculator = new ProfitCalculator();
    }

    /**
     * Put in order calls item from menuitem class
     * @param itemID
     */
    public void addItem(int itemID) throws IllegalArgumentException, TooManyInstanceException {
        if (cart.size() >= 100) {throw new TooManyInstanceException("Too many instances! Cart can only add up to 100 items.");}

        MenuItem addedItem = cafe.findMenuItemById(itemID);
        if (addedItem != null) {
            cart.add(addedItem);
            System.out.printf("Added item ID: %d\n", itemID);
        } else {
            throw new IllegalArgumentException("Item not available in cafe's menu!");
        }
    }

    /**
     * Remove item from cart
     * @param itemID
     */
    public void removeItem(int itemID) throws IllegalArgumentException {
        MenuItem addedItem = cafe.findMenuItemById(itemID);
        if (addedItem != null) {
            cart.remove(itemID);
            System.out.printf("Removed item ID: %d\n", itemID);
        } else {
            throw new IllegalArgumentException("Item not existed in the cart!");
        }
    }

    /**
     * Checkout all items in cart, show cart details and the total or profit (for manager)
     * @throws IllegalStateException
     */
    public void checkout() throws CheckoutException {
        if (cart == null || cart.isEmpty()) { 
            System.out.println("Cart is empty!"); 
            return;
        }

        calculator.calculate(cart);
        double total = calculator.getTotal();
        Member member = MemberSignInUp.handleMembership(scanner);

        // Displays items and cost for customer
        for (MenuItem item: cart) {
            System.out.printf("Item: %s. Price: $%.2f\n", item.getName(), item.getPrice());
        }

        System.out.printf("Total: $%.2f\n", total);
        if (member != null) {
            total = member.applyDiscount(total);
            System.out.printf("Your balance: $%.2f\n", member.convertPointsToCash());
            if (member.convertPointsToCash() > total) {
                double temp = total;
                System.out.printf("Discount: -$%.2f\n", temp - total);
                System.out.printf("Total: $%.2f\n", total);
                // TODO: display amount of points that can be gained
                // System.out.printf("Point Reward: %d\n",  0);
            } else {
                throw new IllegalStateException("Don't have enough points to checkout. Remove some item?");
            }
        }

        // Customer can pay or cancel payment
        CheckoutOptions checkoutChoice = null;
        String input;
        do {
            System.out.print("\n1. PAY \t2. CANCEL\tOr press ENTER to go back\nCheckout: ");
            try {
                input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase(EXIT) || input.equals("")) break;
                checkoutChoice = getCheckoutOpt(Integer.parseInt(input));
                if (checkoutChoice == null) { 
                    System.out.println("Unexpected checkout choice!"); 
                    continue;
                }
                switch (checkoutChoice) {
                    case PAY:
                        if (es.isManager(employee)) {
                            if (calculator.getProfit() < 0) {
                                throw new CheckoutException("Profit is negative! Check the cost of ingredients and items.");
                            } else {
                                System.out.printf("Profit: $%.2f", calculator.getProfit());
                                // TODO: member.redeemPoints(member.convertCashToPoint())
                                member.addPoints(total);
                            }
                        }
                        break;
                    case CANCEL:
                        cart.clear();
                        System.out.println("Total: $0.0\n");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 1 for PAY or 2 for CANCEL.");
            }
        } while (checkoutChoice == null);
    }

    /**
     * Convert choice (int) to enum CheckoutOptions type
     * @param choice
     * @return CheckoutOptions
     */
    private CheckoutOptions getCheckoutOpt(int choice) {
        for (CheckoutOptions opt : CheckoutOptions.values()) {
            if (opt.ordinal() == choice - 1) { return opt; }
        }
        return null;
    }
}
