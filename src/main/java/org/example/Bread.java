package org.example;

public class Bread {
    private String name;
    private double price;

    public Bread(BreadType breadType) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Bread(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
