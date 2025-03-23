import cafe.*;
import exceptions.EmployeeSystemException;
import exceptions.TooManyInstanceException;
import model.Employee;
import services.Cart;
import services.EmployeeSystem;
import services.IEmployeeSystem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    /**
     * Handle logic for option 1
     * @param cart
     * @param scanner
     */
    private static void ringUpCustomer(Cart cart, Scanner scanner) {
        String input;
        while (true) {
            System.out.print("\nEnter item ID to add to cart or press ENTER when done or to cancel: ");
            input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase(Cart.EXIT)) {
                break;
            } else if (input.equals("")) {
                input = "1";
                break;
            } else {
                try {
                    cart.addItem(Integer.parseInt(input));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    /**
     * Handle logic for option 2
     * @param es
     * @param manager
     * @param scanner
     */
    private static void addNewEmployee(IEmployeeSystem es, Employee manager, Scanner scanner) throws IllegalArgumentException {
        String input;
        while (true) {
            System.out.print("Enter new employee's name, or press ENTER to cancel: ");
            input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase(Cart.EXIT) || input.equals("")) return;

            String names[] = input.trim().split("\\s+");
            if (names.length < 2) {
                System.out.println("Please enter both first and last name.");
                return;
            }

            String fname = String.join(" ", Arrays.copyOfRange(names, 0, names.length - 1));
            String lname = names[names.length - 1];
            try {
                es.addEmployeeByName(fname, lname, manager);
            } catch (EmployeeSystemException | TooManyInstanceException e) {
                System.out.println(e.getMessage());
            } 
        }
    }

    /**
     * Handle logic for option 3
     * @param es
     * @param employee
     * @param scanner
     * @throws NumberFormatException when input is not numeric
     */
    private static void trackEmployeeHours(IEmployeeSystem es, Employee employee, Scanner scanner) throws NumberFormatException {
        System.out.print("Enter worked hours, or press ENTER to cancel: ");
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase(Cart.EXIT) || input.equals("")) return;

        es.trackEmployeeHours(employee, Double.parseDouble(input));
    }

    /**
     * Handle logic for option 4
     * @param es
     * @param scanner
     */
    private static void removeEmployee(IEmployeeSystem es, Employee manager, Scanner scanner) {
        String input;
        while (true) {
            try {
                System.out.print("Enter the code of the employee you wish to remove, or press ENTER to cancel: ");
                input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase(Cart.EXIT) || input.equals("")) break;

                es.removeEmployeeByCode(Integer.parseInt(input), manager);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in); // will be used for entire program

        // Create a cafe.
        Cafe cafe = new Cafe();

        // Define ingredients for a latte.
        Map<String, Double> latteIngredients = new HashMap<>();
        latteIngredients.put("Espresso", 1.0); // 30ml of espresso.
        latteIngredients.put("Milk", 0.5); // 200ml of milk.
        latteIngredients.put("Sugar", 0.1); // 10g of sugar.

        // Create a latte coffee item.
        MenuItemSubclasses.LatteCoffee latte = new MenuItemSubclasses.LatteCoffee(1, "Latte", 4.5, latteIngredients,
                "Coffee Menu");

        // Add the latte to the cafe's menu.
        try {
            cafe.addMenuItem(latte);
        } catch (TooManyInstanceException e) {
            System.out.println(e.getMessage());
        }

        // Display the cafe's menu.
        cafe.displayMenu();

        System.out.println("\n\nWelcome!");
        String input = "";
        do {
            System.out.print("\nType START, or EXIT to quit: ");
            input = scanner.nextLine().trim();

            try {
                switch (input.toUpperCase()) {
                    case "START":
                        System.out.print("Enter your employee's code: ");
                        input = scanner.nextLine().trim();
                        if (input.equalsIgnoreCase(Cart.EXIT)) break;
                        IEmployeeSystem es = EmployeeSystem.getEmployeeSystem();
                        Employee employee = es.login(Integer.parseInt(input));
                        if (employee == null) {
                            System.out.println("Invalid code. Try again!");
                            break;
                        }
                        Cart cart = new Cart(cafe, es, employee, scanner);

                        while (true) {
                            System.out.println("\nWhat do you want to do?\n"
                                    + "1. Ring up the customer\n"
                                    + "2. Add a new employee\n"
                                    + "3. Track your work hours\n"
                                    + "4. Remove an employee\n"
                                    + "5. Log out\n");
                            System.out.print("\nEnter your choice: ");
                            input = scanner.nextLine().trim();
                            switch (input.toUpperCase()) {
                                case "1":
                                    ringUpCustomer(cart, scanner);
                                    break;
                                case "2":
                                    addNewEmployee(es, employee, scanner);
                                    break;
                                case "3":
                                    trackEmployeeHours(es, employee, scanner);
                                    break;
                                case "4":
                                    removeEmployee(es, employee, scanner);
                                    break;
                                case "5":
                                case Cart.EXIT:
                                    break;
                                default:
                                    System.out.println("Invalid input!\n");
                                    break;
                            }
                            if (input.equalsIgnoreCase(Cart.EXIT) || input.equals("5")) break;
                            if (input.equals("1")) cart.checkout();
                        }
                        break;
                    case Cart.EXIT:
                        break;
                    default:
                        System.out.println("Invalid input!\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!input.equalsIgnoreCase(Cart.EXIT));

        // closing the program
        scanner.close();
    }
}
