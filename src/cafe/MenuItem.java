
package cafe;

import java.util.Map;

// Using abstract class to act as a baseline for all specific menu items.

public abstract class MenuItem {
    private int itemID;
    private String name;
    private double price;
    private Map<String, Double> ingredients;
    private String menu;
    private ItemCategory itemCategory;

    // Constructor
    public MenuItem(int itemID, String name, double price, Map<String, Double> ingredients, String menu, ItemCategory itemCategory) {
        this.itemID = itemID;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.menu = menu;
        this.itemCategory = itemCategory;
    }

    // Getters to get value of item
    public int getItemID() {
        return itemID;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public Map<String, Double> getIngredients() {
        return ingredients;
    }
    public String getMenu() {
        return menu;
    }
    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    // All classes that this abstact class must have a displayItemDetails.
    public abstract void displayItemDetails();
}
