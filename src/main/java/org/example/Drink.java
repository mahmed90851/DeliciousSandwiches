package org.example;

public class Drink implements IOrderable {
    private DrinkType type;
    private DrinkSize size;
    private String flavor;

    public Drink(DrinkType type, DrinkSize size, String flavor) {
        this.type = type;
        this.size = size;
        this.flavor = flavor;
    }

    public double getPrice() {
        return size.getPrice();
    }

    public String getOrderDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Drink: ").append(type.getName()).append("\n");
        details.append("Size: ").append(size.getSize()).append(" oz\n");
        details.append("Flavor: ").append(flavor).append("\n");
        return details.toString();
    }
}
