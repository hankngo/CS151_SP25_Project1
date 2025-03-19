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


public class Cart {
    private enum CheckoutOptions {PAY, CANCEL}
    private IEmployeeSystem es;
    private Scanner scanner; // TODO: Scanner should be share or passed around
    //  Scanner init in main or Cafe
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
    }

    /**
     * Put in order calls item from menuitem class
     * @param itemID
     */
    public void addItem(int itemID) {
        MenuItem addedItem = cafe.findMenuItem(itemID);
        if (addedItem != null) {
            cart.add(addedItem);
        } else {
            //TODO: error not in the list? or sold out (optional)
            System.out.println("Item not avaiable in cafe's menu!");
        }
    }

    /**
     * Remove item from cart
     * @param itemID
     */
    public void removeItem(int itemID) {
        MenuItem addedItem = cafe.findMenuItem(itemID);
        if (addedItem != null) {
            cart.remove(itemID);
        } else {
            //TODO: error not in the list? or sold out (optional)
            System.out.println("Item not existed in the cart!");
        }
    }

    /**
     * Checkout all items in cart, show cart details and the total or profit (for manager)
     * @throws IllegalStateException
     */
    public void checkout () throws IllegalStateException //, TODO: throws CustomException
    {
        if (cart == null || cart.isEmpty()) { throw new IllegalStateException("Cart is empty!"); }

        calculator.calculate(cart);
        double total = calculator.getTotal();
        Member member = MemberSignInUp.handleMembership();

        // Displays items and cost for customer
        for (MenuItem item: cart) {
            System.out.printf("Item: %s. Price: %d\n", item.getName(), item.getPrice());
        }

        System.out.printf("Total: %d\n", total);
        if (member != null) {
            double temp = total;
            total = member.applyDiscount(total);
            System.out.printf("Discount: -%d", temp - total);
            System.out.printf("Total: %d\n", total);
            // display amount of points that can be gained
            //TODO: member.convertCashToPoints (points that can be gained)
            System.out.printf("Point Reward: %d",  0);
        }

        // Customer can pay or cancel payment
        CheckoutOptions checkoutChoice = null;
        do {
            System.out.println("\n1. PAY \t2. CANCEL\nCheckout: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                checkoutChoice = getCheckoutOpt(choice);
                switch (checkoutChoice) {
                    case PAY:
                        if (es.isManager(employee)) {
                            if (calculator.getProfit() < 0) {
                                // throw new CustomException();
                            } else {
                                System.out.printf("Profit: %d", calculator.getProfit());
                                // TODO: member.redeemPoints(member.convertCashToPoint())
                                member.addPoints(total);
                            }
                        }
                        break;
                    case CANCEL:
                        cart.clear();
                        System.out.printf("Total: %d\n", 0);
                        break;
                    default:
                        System.out.println("Unexpected checkout choice!");
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
