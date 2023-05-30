package org.example;

public enum ToppingCategory {
    REGULAR("Regular"),
    PREMIUM("Premium");

    private String name;

    private ToppingCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
