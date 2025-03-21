package cafe;

import java.util.HashMap;
import java.util.Map;

public class Cafe {
    private Map<String, MenuItem> menuItems;

    public Cafe() {
        this.menuItems = new HashMap<>();
    }

    public void addMenuItem(MenuItem item) {
        menuItems.put(item.getName(), item);
    }

    public void displayMenu() {
        for (Map.Entry<String, MenuItem> entry : menuItems.entrySet()) {
            System.out.println("Item Name: " + entry.getKey());
            entry.getValue().displayItemDetails();
        }
    }

    public MenuItem findMenuItemById(int itemID) {
        // Iterate through the values of the menuItems map
        for (MenuItem item : menuItems.values()) {
            if (item.getItemID() == itemID) {
                return item;
            }
        }
        return null; // Item not found
    }

    // Process an order (simplified for now)
    public void processOrder(int itemID) {
        MenuItem item = findMenuItemById(itemID);
        if (item != null) {
            System.out.println("Order processed: " + item.getName());
        } else {
            System.out.println("Item not found in the menu.");
        }
    }
}
