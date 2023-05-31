package org.example;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderableItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addOrderable(OrderableItem item) {
        items.add(item);
    }

    public void removeOrderable(OrderableItem item) {
        items.remove(item);
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (OrderableItem item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public String getReceipt() {
        StringBuilder receipt = new StringBuilder();
        for (OrderableItem item : items) {
            receipt.append(item.getOrderDetails()).append("\n");
        }
        return receipt.toString();
    }

    public void clear() {
        items.clear();
    }
}
