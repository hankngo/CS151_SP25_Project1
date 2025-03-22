import cafe.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in); // will be used for entire program

        // Create a cafe.
        Cafe cafe = new Cafe();

        // Define ingredients for a latte.
        Map<String, Double> latteIngredients = new HashMap<>();
        latteIngredients.put("Espresso", 30.0); // 30ml of espresso.
        latteIngredients.put("Milk", 200.0);   // 200ml of milk.
        latteIngredients.put("Sugar", 10.0);   // 10g of sugar.

        // Create a latte coffee item.
        MenuItemSubclasses.LatteCoffee latte = new MenuItemSubclasses.LatteCoffee(1, "Latte", 4.5, latteIngredients, "Coffee Menu");

        // Add the latte to the cafe's menu.
        cafe.addMenuItem(latte);

        // Display the cafe's menu.
        cafe.displayMenu();




        // closing the program
        scanner.close();
    }
}
