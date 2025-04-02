package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import services.Cart;
import services.EmployeeSystem;
import services.IEmployeeSystem;
import services.ProfitCalculator;
import model.Employee;
import cafe.Cafe;
import cafe.MenuItem;
import cafe.MenuItemSubclasses;
import exceptions.CheckoutException;
import exceptions.TooManyInstanceException;

import java.util.*;
import java.io.*;

public class CartTest {
    private Cart cart;
    private Cafe mockCafe;
    private IEmployeeSystem mockSystem;
    private Employee mockEmployee;
    private Scanner scanner;

    private MenuItem latte;

    @Before
    public void setUp() {
        mockCafe = new Cafe();;
        mockSystem = EmployeeSystem.getEmployeeSystem();
        mockEmployee = mockSystem.login(151);

        // Set up a basic menu item
        // use the same code in ProfitCalculator

        scanner = new Scanner(System.in);
        
        Map<String, Double> ingredients = new HashMap<>();
        ingredients.put("Water", 0.2);
        ingredients.put("Coffee", 0.5);

        MenuItemSubclasses.LatteCoffee mockLatteCoffee = new MenuItemSubclasses.LatteCoffee(1, "Latte", 4.0, ingredients, "Coffee Menu");

        try {
            mockCafe.addMenuItem(mockLatteCoffee);
        } catch (TooManyInstanceException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testAddItem() {

        cart = new Cart(mockCafe, mockSystem, mockEmployee, scanner);

        try {
            for (int i = 0; i <= 101; i++) {
                cart.addItem(1);
            }
        } catch (Exception e) {
            assertEquals("Too many instances! Cart can only add up to 100 items.", e.getMessage());
        }

        try {
            for(int i = 0; i < 99; i++)
            {
                cart.removeItem(1);
            }
            cart.addItem(999);
        } catch (Exception e) {
            assertEquals("Item not available in cafe's menu!", e.getMessage());
        }
    }

    @Test
    public void testRemoveItem() {

        cart = new Cart(mockCafe, mockSystem, mockEmployee, scanner);

        try {
            for(int i = 0; i <= 3; i++)
            {
                cart.addItem(1);
            }
        }
        catch (Exception e)
        {
            assertEquals("Item not available in cafe's menu!", e.getMessage());
        }

        cart.removeItem(1); // should pass

        try {
            cart.removeItem(999);
        } catch (Exception e) {
            assertEquals("Item not existed in the cart!", e.getMessage());
        }
    }
}