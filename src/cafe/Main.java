package cafe;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create a cafe
        Cafe cafe = new Cafe();

        // Create menu items
        MenuItem sweetPastry = new SweetPastry(1, "Sweet Pastry", 3.0, Arrays.asList("Flour", "Sugar", "Butter"), "Pastries");
        MenuItem savoryPastry = new SavoryPastry(2, "Savory Pastry", 3.5, Arrays.asList("Flour", "Cheese", "Herbs"), "Pastries");
        MenuItem sourdoughBread = new SourdoughBread(3, "Sourdough Bread", 5.0, Arrays.asList("Flour", "Water", "Salt"), "Bread");
        MenuItem latteCoffee = new LatteCoffee(4, "Latte", 4.5, Arrays.asList("Espresso", "Milk"), "Coffee");
        MenuItem hotTea = new HotTea(5, "Hot Tea", 2.5, Arrays.asList("Tea Leaves", "Hot Water"), "Tea");

        // Add items to the cafe menu
        cafe.addMenuItem(sweetPastry);
        cafe.addMenuItem(savoryPastry);
        cafe.addMenuItem(sourdoughBread);
        cafe.addMenuItem(latteCoffee);
        cafe.addMenuItem(hotTea);

        // Display the menu
        cafe.displayMenu();
    }
}