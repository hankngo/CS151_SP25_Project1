
package cafe;

import java.util.HashMap;
import java.util.Map;

public class Cafe {
    private Map<String, MenuItem> menuItems;

    // Constructor
    public Cafe() {
        this.menuItems = new HashMap<>();
    }

    // Adding menu item
    public void addMenuItem(MenuItem item) {
        menuItems.put(item.getName(), item);
    }


	// Get all menu items
	public Map<String, MenuItem> getMenuItems() {
	    return menuItems;
	}
	
	// Get a menu item by name
	public MenuItem getMenuItem(String itemName) {
	    return menuItems.get(itemName);
	}
	
    // Display Menu Item
    public void displayMenu() {
        for (Map.Entry<String, MenuItem> entry : menuItems.entrySet()) {
            System.out.println("Item Name: " + entry.getKey());
            entry.getValue().displayItemDetails();
        }
    }

    // Finding Menu item by it's ID
    public MenuItem findMenuItemById(int itemID) {
        // Loop through the values of the menuItems 
        for (MenuItem item : menuItems.values()) {
            if (item.getItemID() == itemID) {
                return item;
            }
        }
        return null; // Item not found
    }

    // Processing an order
    public void processOrder(int itemID) {
        MenuItem item = findMenuItemById(itemID);
        if (item != null) {
            System.out.println("Order processed: " + item.getName());
        } else {
            System.out.println("Item not found in the menu.");
        }
    }
}
