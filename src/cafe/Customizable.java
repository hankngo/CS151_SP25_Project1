package cafe;
import java.util.*;

//Interface defning customization options for menu items

public interface Customizable {
 void setGlutenFree(boolean glutenFree); // Set whether item is gluten-free
 void setNutFree(boolean nutFree);       // Set whether item is nut-free
 void setVegan(boolean vegan);           // Set whther item is vegan
 void setSweetnessLevel(int level);        // Set sweetness level (e.g., 0-5 scale)
}