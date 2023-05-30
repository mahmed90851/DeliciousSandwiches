package org.example;

public class Drink {
    private int size;
    private String flavor;

    private String orderDetails;

    private double price;

    public Drink(int size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public double getPrice() {
        return price;
    }
}
