package test;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

// Import the need classes from cafe packages
import cafe.Cafe;
import cafe.MenuItem; 
import cafe.MenuItemSubclasses;

public class MainTest {

    @Test
    public void testAddLatteToCafeMenu() {
        try {
            // Create a cafe
            Cafe cafe = new Cafe();

            // Define ingredients parameters for a latte
            Map<String, Double> latteIngredients = new HashMap<>();
            latteIngredients.put("Espresso", 30.0); // 30 of espresso
            latteIngredients.put("Milk", 200.0);   // 200 of milk
            latteIngredients.put("Sugar", 10.0);   // 10 of sugar

            // Create a latte coffee item
            MenuItemSubclasses.LatteCoffee latte = new MenuItemSubclasses.LatteCoffee(1, "Latte", 4.5, latteIngredients, "Coffee Menu");

            // Add the latte to the cafe's meun
            cafe.addMenuItem(latte);

            // Check that latte was added to the menu
            MenuItem retrievedItem = cafe.findMenuItemById(1); 
            assertNotNull(retrievedItem); 
            assertEquals(latte, retrievedItem); // The retrieved item must be the latte
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testLatteCoffeeProperties() {
        try {
            // Define ingredients parameters for a latte
            Map<String, Double> latteIngredients = new HashMap<>();
            latteIngredients.put("Espresso", 30.0); // 30 of espresso
            latteIngredients.put("Milk", 200.0);   // 200 of mllk
            latteIngredients.put("Sugar", 10.0);   // 10 of sugar

            // Create a latte coffee item
            MenuItemSubclasses.LatteCoffee latte = new MenuItemSubclasses.LatteCoffee(1, "Latte", 4.5, latteIngredients, "Coffee Menu");

            // Check the properties of the latte
            assertEquals(1, latte.getItemID()); //  ID should be 1
            assertEquals("Latte", latte.getName()); // Name should be "Latte"
            assertEquals(4.5, latte.getPrice(), 0.001); // Price should be 4.5
            assertEquals(latteIngredients, latte.getIngredients()); // Latte ingredients should match
            assertEquals("Coffee Menu", latte.getMenu()); // Menu type should be Coffee Menu
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testFindMenuItemById() {
        try {
            // Create a cafe
            Cafe cafe = new Cafe();

            // Define ingredients for a latte
            Map<String, Double> latteIngredients = new HashMap<>();
            latteIngredients.put("Espresso", 30.0); // 30ml of espresso
            latteIngredients.put("Milk", 200.0);   // 200ml of milk
            latteIngredients.put("Sugar", 10.0);   // 10g of sugar

            // Create a latte coffee item
            MenuItemSubclasses.LatteCoffee latte = new MenuItemSubclasses.LatteCoffee(1, "Latte", 4.5, latteIngredients, "Coffee Menu");

            // Add the latte to the cafe's menu
            cafe.addMenuItem(latte);

            // Find the menu item by its ID
            MenuItem foundItem = cafe.findMenuItemById(1);

            // Check that the found item is the same as the added latte
            assertNotNull(foundItem); 
            assertEquals(latte, foundItem); 
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testProcessOrder() {
        try {

            Cafe cafe = new Cafe();

            // Define ingredients for a latte
            Map<String, Double> latteIngredients = new HashMap<>();
            latteIngredients.put("Espresso", 30.0); 
            latteIngredients.put("Milk", 200.0);  
            latteIngredients.put("Sugar", 10.0); 

            MenuItemSubclasses.LatteCoffee latte = new MenuItemSubclasses.LatteCoffee(1, "Latte", 4.5, latteIngredients, "Coffee Menu");

            cafe.addMenuItem(latte);

            // Process an order for the latte
            cafe.processOrder(1);

            // Process an order for a non-existent item
            cafe.processOrder(999); // Should print Item not found in the menu.
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}