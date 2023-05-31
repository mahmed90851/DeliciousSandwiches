package org.example;
import java.util.ArrayList;
import java.util.List;

public class Sandwich implements OrderableItem {
    private Bread bread;
    private List<Topping> toppings;
    private List<Sauce> sauces;
    private SandwichSize size;
    private boolean toasted;

    public Sandwich(Bread bread, SandwichSize size) {
        this.bread = bread;
        this.size = size;
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.toasted = false;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    public void addSauce(Sauce sauce) {
        sauces.add(sauce);
    }

    public void removeSauce(Sauce sauce) {
        sauces.remove(sauce);
    }

    public double getPrice() {
        return bread.getPrice();
    }

    public String getOrderDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Size: ").append(size.getSize()).append("\"\n");
        details.append("Bread: ").append(bread.getName()).append("\n");
        details.append("Toppings: ").append("\n");

        for (Topping topping : toppings) {
            details.append("- ").append(topping.getName()).append("\n");
        }

        details.append("Sauces: ").append("\n");

        for (Sauce sauce : sauces) {
            details.append("- ").append(sauce.getName()).append("\n");
        }

        details.append("Toasted: ").append(toasted ? "Yes" : "No").append("\n");

        return details.toString();
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }
}
