package org.example;

public enum SauceType {
    MAYO("Mayo"),
    MUSTARD("Mustard"),
    KETCHUP("Ketchup"),
    RANCH("Ranch"),
    THOUSAND_ISLANDS("Thousand Islands"),
    VINAIGRETTE("Vinaigrette"),
    SIDE_SAUCE("Sauce"),
    SIDE_AU_JUS("Au jus");

    private String name;

    SauceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
