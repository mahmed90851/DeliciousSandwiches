package org.example;

public enum Topping {
    LETTUCE("Lettuce", ToppingCategory.REGULAR),
    PEPPERS("Peppers", ToppingCategory.REGULAR),
    ONIONS("Onions", ToppingCategory.REGULAR),
    TOMATOES("Tomatoes", ToppingCategory.REGULAR),
    JALEPENOS("Jalepenos", ToppingCategory.REGULAR),
    CUCUMBERS("Cucumbers", ToppingCategory.REGULAR),
    PICKLES("Pickles", ToppingCategory.REGULAR),
    GUACAMOLE("Guacamole", ToppingCategory.REGULAR),
    MUSHROOMS("Mushrooms", ToppingCategory.REGULAR),
    STEAK("Steak", ToppingCategory.PREMIUM),
    HAM("Ham", ToppingCategory.PREMIUM),
    SALAMI("Salami", ToppingCategory.PREMIUM),
    ROAST_BEEF("Roast Beef", ToppingCategory.PREMIUM),
    CHICKEN("Chicken", ToppingCategory.PREMIUM),
    BACON("Bacon", ToppingCategory.PREMIUM),
    AMERICAN_CHEESE("American", ToppingCategory.PREMIUM),
    PROVOLONE_CHEESE("Provolone", ToppingCategory.PREMIUM),
    CHEDDAR_CHEESE("Cheddar", ToppingCategory.PREMIUM),
    SWISS_CHEESE("Swiss", ToppingCategory.PREMIUM);

    private String name;
    private ToppingCategory category;

    private Topping(String name, ToppingCategory category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public ToppingCategory getCategory() {
        return category;
    }
}
