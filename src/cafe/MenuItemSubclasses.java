package cafe;

import java.util.Map;


// Subclasses that act as specific type of menu item item in the cafe.
// All subclasses must implement the displayItemDetails method since we use the actract class MenuItem
// Use public static for each subclasses so it's easier to creates and use the subclasses without needing an instance of the MenuItemSubclasses class

public class MenuItemSubclasses {

	// Subclasses for each menu item
	// Using super to overide the parent class
	public static class SweetPastry extends MenuItem {
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
	// Subclasses for each menu item
	// Using super to overide the parent class
	public static class SavoryPastry extends MenuItem {
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

	// Subclasses for each menu item
	// Using super to overide the parent class
	public static class SourdoughBread extends MenuItem {
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

	// Subclasses for each menu item
	// Using super to overide the parent class
	public static class BaguetteBread extends MenuItem {
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

	// Subclasses for each menu item
	// Using super to overide the parent class
	public static class LatteCoffee extends MenuItem {
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

	// Subclasses for each menu item
	// Using super to overide the parent class
	public static class HotCoffee extends MenuItem {
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

	// Subclasses for each menu item
	// Using super to overide the parent class
	public static class ColdCoffee extends MenuItem {
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

	// Subclasses for each menu item
	// Using super to overide the parent class
	public static class HotTea extends MenuItem {
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

	// Subclasses for each menu item
	// Using super to overide the parent class
	public static class ColdTea extends MenuItem {
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
}