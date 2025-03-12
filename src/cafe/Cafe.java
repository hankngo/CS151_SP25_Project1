package cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<MenuItem> menuItems;

    public Cafe() {
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public void removeMenuItem(int itemID) {
        menuItems.removeIf(item -> item.getItemID() == itemID); // Ensure getItemID() is defined
    }

    public void displayMenu() {
        for (MenuItem item : menuItems) {
            item.displayItemDetails();
        }
    }

    public MenuItem findMenuItem(int itemID) {
        for (MenuItem item : menuItems) {
            if (item.getItemID() == itemID) { // Ensure getItemID() is defined
                return item;
            }
        }
        return null;
    }
}