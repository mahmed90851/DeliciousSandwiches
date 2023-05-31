package org.example;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<IOrderable> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addOrderable(IOrderable item) {
        items.add(item);
    }

    public void removeOrderable(IOrderable item) {
        items.remove(item);
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (IOrderable item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public String getReceipt() {
        StringBuilder receipt = new StringBuilder();
        for (IOrderable item : items) {
            receipt.append(item.getOrderDetails()).append("\n");
        }
        return receipt.toString();
    }

    public void clear() {
        items.clear();
    }
}
