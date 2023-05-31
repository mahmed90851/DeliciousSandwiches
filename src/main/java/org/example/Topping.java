package org.example;


public class Topping {
    private String name;
    private ToppingType type;
    private double price;

    public Topping(String name, ToppingType type, double cost) {
        this.name = name;
        this.type = type;
        this.price = cost;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ToppingType getType() {
        return type;
    }

    public void setType(ToppingType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // toString method
    @Override
    public String toString() {
        return name;
    }
}
