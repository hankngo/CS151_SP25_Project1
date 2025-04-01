package test;

import static org.junit.Assert.*;
import org.junit.Test;
import services.ProfitCalculator;
import cafe.MenuItem;
import cafe.MenuItemSubclasses;
import machines.Machine;

import java.util.*;

public class ProfitCalculatorTest {

    @Test
    public void testCalculateTotalAndProfit() {
        ProfitCalculator calculator = new ProfitCalculator();
        Map<String, Double> ingredients = new HashMap<>();
        ingredients.put("Water", 0.2);
        ingredients.put("Coffee", 0.5);

        MenuItemSubclasses.LatteCoffee mockLatteCoffee = new MenuItemSubclasses.LatteCoffee(1, "Latte", 4.0, ingredients, "Coffee Menu");

        List<MenuItem> cart = Arrays.asList(mockLatteCoffee);
        calculator.calculate(cart);

        assertEquals(4.0, calculator.getTotal(), 0.001);
        double expectedProfit = 4.0 - (0.2 + 0.5) - Machine.totalMachineRepairCosts;
        assertEquals(expectedProfit, calculator.getProfit(), 0.001);
    }
}