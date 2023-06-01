package org.example;

public enum DrinkSize {
    SMALL(2.00, "small"),
    MEDIUM(2.50, "medium"),
    LARGE(3.00, "large");

    private final double price;
    private final String size;

    DrinkSize(double price, String size) {
        this.price = price;
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }
}
