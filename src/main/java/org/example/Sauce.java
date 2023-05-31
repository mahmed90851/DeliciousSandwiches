package org.example;

public class Sauce {
    private String name;
    private double cost;

    public Sauce(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    // toString method
    @Override
    public String toString() {
        return name;
    }
}
