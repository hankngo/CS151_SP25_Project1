package cafe;

import java.util.Map;

// Subclasses for each menu item
class SweetPastry extends MenuItem {
    public SweetPastry(int itemID, String name, double price, Map<String, Double> ingredients, String menu) {
        super(itemID, name, price, ingredients, menu, ItemCategory.PASTRIES_SWEET);
    }

    @Override
    public void displayItemDetails() {
        System.out.println("Item ID: " + getItemID());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Ingredients: " + getIngredients());
        System.out.println("Menu: " + getMenu());
        System.out.println("Category: " + getItemCategory());
    }
}

class SavoryPastry extends MenuItem {
    public SavoryPastry(int itemID, String name, double price, Map<String, Double> ingredients, String menu) {
        super(itemID, name, price, ingredients, menu, ItemCategory.PASTRIES_SAVORY);
    }

    @Override
    public void displayItemDetails() {
        System.out.println("Item ID: " + getItemID());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Ingredients: " + getIngredients());
        System.out.println("Menu: " + getMenu());
        System.out.println("Category: " + getItemCategory());
    }
}

class SourdoughBread extends MenuItem {
    public SourdoughBread(int itemID, String name, double price, Map<String, Double> ingredients, String menu) {
        super(itemID, name, price, ingredients, menu, ItemCategory.BREAD_SOURDOUGH);
    }

    @Override
    public void displayItemDetails() {
        System.out.println("Item ID: " + getItemID());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Ingredients: " + getIngredients());
        System.out.println("Menu: " + getMenu());
        System.out.println("Category: " + getItemCategory());
    }
}

class BaguetteBread extends MenuItem {
    public BaguetteBread(int itemID, String name, double price, Map<String, Double> ingredients, String menu) {
        super(itemID, name, price, ingredients, menu, ItemCategory.BREAD_BAGUETTE);
    }

    @Override
    public void displayItemDetails() {
        System.out.println("Item ID: " + getItemID());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Ingredients: " + getIngredients());
        System.out.println("Menu: " + getMenu());
        System.out.println("Category: " + getItemCategory());
    }
}

class LatteCoffee extends MenuItem {
    public LatteCoffee(int itemID, String name, double price, Map<String, Double> ingredients, String menu) {
        super(itemID, name, price, ingredients, menu, ItemCategory.COFFEE_LATTE);
    }

    @Override
    public void displayItemDetails() {
        System.out.println("Item ID: " + getItemID());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Ingredients: " + getIngredients());
        System.out.println("Menu: " + getMenu());
        System.out.println("Category: " + getItemCategory());
    }
}

class HotCoffee extends MenuItem {
    public HotCoffee(int itemID, String name, double price, Map<String, Double> ingredients, String menu) {
        super(itemID, name, price, ingredients, menu, ItemCategory.COFFEE_HOT);
    }

    @Override
    public void displayItemDetails() {
        System.out.println("Item ID: " + getItemID());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Ingredients: " + getIngredients());
        System.out.println("Menu: " + getMenu());
        System.out.println("Category: " + getItemCategory());
    }
}

class ColdCoffee extends MenuItem {
    public ColdCoffee(int itemID, String name, double price, Map<String, Double> ingredients, String menu) {
        super(itemID, name, price, ingredients, menu, ItemCategory.COFFEE_COLD);
    }

    @Override
    public void displayItemDetails() {
        System.out.println("Item ID: " + getItemID());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Ingredients: " + getIngredients());
        System.out.println("Menu: " + getMenu());
        System.out.println("Category: " + getItemCategory());
    }
}

class HotTea extends MenuItem {
    public HotTea(int itemID, String name, double price, Map<String, Double> ingredients, String menu) {
        super(itemID, name, price, ingredients, menu, ItemCategory.TEA_HOT);
    }

    @Override
    public void displayItemDetails() {
        System.out.println("Item ID: " + getItemID());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Ingredients: " + getIngredients());
        System.out.println("Menu: " + getMenu());
        System.out.println("Category: " + getItemCategory());
    }
}

class ColdTea extends MenuItem {
    public ColdTea(int itemID, String name, double price, Map<String, Double> ingredients, String menu) {
        super(itemID, name, price, ingredients, menu, ItemCategory.TEA_COLD);
    }

    @Override
    public void displayItemDetails() {
        System.out.println("Item ID: " + getItemID());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Ingredients: " + getIngredients());
        System.out.println("Menu: " + getMenu());
        System.out.println("Category: " + getItemCategory());
    }
}