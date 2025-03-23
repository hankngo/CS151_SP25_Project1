/*
 * `ProfitCalculator` calculates the total revenue and profit.
 */

package services;

import java.util.List;

import cafe.MenuItem;
import machines.CoffeeMachine;
import machines.EspressoMachine;
import machines.Kettle;
import machines.Machine;
import machines.Oven;

public class ProfitCalculator {
    private double total;
    private double profit;

    CoffeeMachine coffeeMachine = new CoffeeMachine();
    EspressoMachine espressoMachine = new EspressoMachine();
    Kettle kettle = new Kettle();
    Oven oven = new Oven();

    public double getTotal() {
        return this.total;
    }

    public double getProfit() {
        return this.profit;
    }

    public void calculate(List<MenuItem> cart) {
        double total = 0;
        double cost = 0;
        for (MenuItem item: cart) {

            if(coffeeMachine.checkCoffee(item) == true)
            {
                coffeeMachine.createCoffee(1);
            }
            else if(espressoMachine.checkEspresso(item) == true)
            {
                espressoMachine.createEspresso(1);
            }
            else if(kettle.checkTea(item) == true)
            {
                kettle.createTea(1);
            }
            else if(oven.checkPastry(item) == true)
            {
                oven.createPastries(1);
            }

            total += item.getPrice();
            for (double c : item.getIngredients().values()) {
                cost += c;
            }
        }
        
        this.profit = total - cost - Machine.totalMachineRepairCosts;
        this.total = total;
    }
}
