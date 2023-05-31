package org.example;

public enum Topping {
    LETTUCE("Lettuce", 0.0, ToppingType.REGULAR),
    PEPPERS("Peppers", 0.0, ToppingType.REGULAR),
    ONIONS("Onions", 0.0, ToppingType.REGULAR),
    TOMATOES("Tomatoes", 0.0, ToppingType.REGULAR),
    JALEPENOS("Jalepenos", 0.0, ToppingType.REGULAR),
    CUCUMBERS("Cucumbers", 0.0, ToppingType.REGULAR),
    PICKLES("Pickles", 0.0, ToppingType.REGULAR),
    GUACAMOLE("Guacamole", 0.0, ToppingType.REGULAR),
    MUSHROOMS("Mushrooms", 0.0, ToppingType.REGULAR),
    MAYO("Mayo", 0.0, ToppingType.REGULAR),
    MUSTARD("Mustard", 0.0, ToppingType.REGULAR),
    KETCHUP("Ketchup", 0.0, ToppingType.REGULAR),
    RANCH("Ranch", 0.0, ToppingType.REGULAR),
    THOUSAND_ISLANDS("Thousand Islands", 0.0, ToppingType.REGULAR),
    VINAIGRETTE("Vinaigrette", 0.0, ToppingType.REGULAR),
    STEAK("Steak", 1.0, ToppingType.PREMIUM),
    HAM("Ham", 1.0, ToppingType.PREMIUM),
    SALAMI("Salami", 1.0, ToppingType.PREMIUM),
    ROAST_BEEF("Roast Beef", 1.0, ToppingType.PREMIUM),
    CHICKEN("Chicken", 1.0, ToppingType.PREMIUM),
    BACON("Bacon", 1.0, ToppingType.PREMIUM),
    AMERICAN_CHEESE("American Cheese", 0.75, ToppingType.PREMIUM),
    PROVOLONE_CHEESE("Provolone Cheese", 0.75, ToppingType.PREMIUM),
    CHEDDAR_CHEESE("Cheddar Cheese", 0.75, ToppingType.PREMIUM),
    SWISS_CHEESE("Swiss Cheese", 0.75, ToppingType.PREMIUM);

    private String name;
    private double price;
    private ToppingType type;

    Topping(String name, double price, ToppingType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ToppingType getType() {
        return type;
    }
}

