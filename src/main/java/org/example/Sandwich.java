package org.example;
import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private Bread bread;
    private List<Topping> toppings;
    private int size;
    private boolean toasted;

    public Sandwich(Bread bread, int size) {
        this.bread = bread;
        this.size = size;
        this.toppings = new ArrayList<>();
        this.toasted = false;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    public double getPrice() {
        double total = bread.getPrice();

        for (Topping topping : toppings) {
            total += topping.getPrice();
        }

        return total;
    }

    public String getOrderDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Size: ").append(size).append("\"\n");
        details.append("Bread: ").append(bread.getName()).append("\n");
        details.append("Toppings: ").append("\n");

        for (Topping topping : toppings) {
            details.append("- ").append(topping.getName()).append("\n");
        }

        details.append("Toasted: ").append(toasted ? "Yes" : "No").append("\n");

        return details.toString();
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }
}
