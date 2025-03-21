package cafe;

import java.util.Map;

public abstract class MenuItem {
    private int itemID;
    private String name;
    private double price;
    private Map<String, Double> ingredients;
    private String menu;
    private ItemCategory itemCategory;

    public MenuItem(int itemID, String name, double price, Map<String, Double> ingredients, String menu, ItemCategory itemCategory) {
        this.itemID = itemID;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.menu = menu;
        this.itemCategory = itemCategory;
    }

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

    public abstract void displayItemDetails();
}