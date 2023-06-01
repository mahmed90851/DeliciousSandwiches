package org.example;

public enum SauceType {
    MAYO("Mayo"),
    MUSTARD("Mustard"),
    KETCHUP("Ketchup"),
    RANCH("Ranch"),
    THOUSAND_ISLANDS("Thousand Islands"),
    VINAIGRETTE("Vinaigrette");

    private String name;

    SauceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
