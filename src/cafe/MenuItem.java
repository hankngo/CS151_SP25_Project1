package cafe;

import java.util.List;

public abstract class MenuItem {
    private int itemID;
    private String name;
    private double price;
    private List<String> ingredients;
    private String menu;
    private ItemCategory itemCategory;

    // Constructor
    public MenuItem(int itemID, String name, double price, List<String> ingredients, String menu, ItemCategory itemCategory) {
        this.itemID = itemID;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.menu = menu;
        this.itemCategory = itemCategory;
    }

    // Getters and setters
    public int getItemID() {
        return itemID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getMenu() {
        return menu;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    // Abstract method to display item details
    public abstract void displayItemDetails();
}