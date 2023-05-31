package org.example;

public enum DrinkSize {
    SMALL(2.00, 8),
    MEDIUM(2.50, 12),
    LARGE(3.00, 16);

    private final double price;
    private final int size;

    DrinkSize(double price, int size) {
        this.price = price;
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }
}
