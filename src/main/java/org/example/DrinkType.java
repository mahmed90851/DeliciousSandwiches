package org.example;

public enum DrinkType {
    SODA("Soda"),
    WATER("Water"),
    JUICE("Juice"),
    TEA("Tea"),
    COFFEE("Coffee");

    private final String name;

    DrinkType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
