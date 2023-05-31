package org.example;

public class Chip implements OrderableItem {
    private final ChipType type;


    public Chip(ChipType type) {
        this.type = type;
    }

    public double getPrice() {
        return 1.50;
    }

    public String getOrderDetails() {
        return "Chip: " + type.getName();
    }
}
