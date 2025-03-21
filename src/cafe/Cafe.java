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

    public void displayMenu() {
        for (MenuItem item : menuItems) {
            item.displayItemDetails();
        }
    }
}