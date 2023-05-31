package org.example;

public enum ChipType {
    REGULAR("Regular"),
    BBQ("BBQ"),
    SOUR_CREAM_AND_ONION("Sour Cream & Onion"),
    SALTED("Salted"),
    CHEESE("Cheese"),
    SPICY("Spicy");

    private final String name;

    ChipType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
