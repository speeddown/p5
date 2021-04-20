package com.example.project5;

import java.util.ArrayList;

public class TotalCoffeeOrder {
    CoffeeOrder.Size size = null;
    ArrayList<String> addOns = new ArrayList<>();
    double total = 0.00;

    public TotalCoffeeOrder() {
    }

    public TotalCoffeeOrder(CoffeeOrder.Size size, ArrayList<String> addOns){
        this.size = size;
        this.addOns = addOns;
    }

    public CoffeeOrder.Size getSize() {
        return size;
    }

    public void setSize(CoffeeOrder.Size size) {
        this.size = size;
    }

    public void addAddOn(String addOn){
        if(!this.addOns.contains(addOn)){
            this.addOns.add(addOn);
        }
    }

    public void removeAddOn(String addOn){
        this.addOns.remove(addOn);
    }

    public ArrayList<String> getAddOns() {
        return addOns;
    }

    public void setAddOns(ArrayList<String> addOns) {
        this.addOns = addOns;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
