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
        receipt.append("Order Details:\n");

        String format = "%-30s %10s%n"; // Adjust the padding as needed

        for (OrderableItem item : items) {
            receipt.append("------------------------------------\n");
            receipt.append(item.getOrderDetails());
            receipt.append(String.format(format, "Price:", String.format("$%.2f", item.getPrice())));
            receipt.append("------------------------------------\n");
        }

        receipt.append("------------------------------------\n");
        receipt.append(String.format(format, "Total Price:", String.format("$%.2f", getTotalPrice())));
        receipt.append("------------------------------------\n");

        return receipt.toString();
    }


    public void clear() {
        items.clear();
    }

    public List<OrderableItem> getItems() {
        return items;
    }
}
