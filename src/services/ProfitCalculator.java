/*
 * `ProfitCalculator` calculates the total revenue and profit.
 */

package services;

import java.util.List;

import cafe.MenuItem;

public class ProfitCalculator {
    private double total;
    private double profit;

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
            total += item.getPrice();
            // TODO: calculate cost. item.getIngredients() should return HashMap
            // for (double c : item.getIngredients().values()) {
            //     cost += c;
            // }
        }
        this.profit = total - cost;
        this.total = total;
    }
}
