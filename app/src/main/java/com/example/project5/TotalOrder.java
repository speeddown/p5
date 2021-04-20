package com.example.project5;

import java.io.Serializable;

public class TotalOrder implements Serializable {
    TotalDonutOrder totalDonutOrder = null;
    TotalCoffeeOrder totalCoffeeOrder = null;
    double total = 0.00;
    double salesTax = 0.00;

    public TotalOrder(){
        totalDonutOrder = new TotalDonutOrder();
        totalCoffeeOrder = new TotalCoffeeOrder();
    }

    public TotalOrder(TotalDonutOrder totalDonutOrder){
        this.totalDonutOrder = totalDonutOrder;
    }

    public TotalOrder(TotalCoffeeOrder totalCoffeeOrder){
        this.totalCoffeeOrder = totalCoffeeOrder;
    }

    public TotalOrder(TotalDonutOrder totalDonutOrder, TotalCoffeeOrder totalCoffeeOrder){
        this.totalCoffeeOrder = totalCoffeeOrder;
        this.totalDonutOrder = totalDonutOrder;
    }

    public TotalDonutOrder getTotalDonutOrder() {
        return totalDonutOrder;
    }

    public void setTotalDonutOrder(TotalDonutOrder totalDonutOrder) {
        this.totalDonutOrder = totalDonutOrder;
    }

    public TotalCoffeeOrder getTotalCoffeeOrder() {
        return totalCoffeeOrder;
    }

    public void setTotalCoffeeOrder(TotalCoffeeOrder totalCoffeeOrder) {
        this.totalCoffeeOrder = totalCoffeeOrder;
    }

    public double getTotal() {
        this.total = this.totalCoffeeOrder.total;
                // make sure to add this.totalDonutOrder.total to above line to get accurate TotalOrder
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
        this.salesTax = total * .06625;
    }
}
