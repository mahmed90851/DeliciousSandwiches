package org.example;

public class Drink implements OrderableItem {
    private DrinkType type;
    private DrinkSize size;

    public Drink(DrinkType type, DrinkSize size) {
        this.type = type;
        this.size = size;
    }

    public double getPrice() {
        return size.getPrice();
    }

    public String getOrderDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Drink: ").append(type.getName()).append("\n");
        details.append("Size: ").append(size.getSize()).append(" oz\n");
        return details.toString();
    }
}
