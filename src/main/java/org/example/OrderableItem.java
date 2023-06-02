package org.example;

public interface OrderableItem {
    //this abstract method is used to get the price of the item.
    double getPrice();
    //used to get details of the items in a formatted string. contains information about the item such as size, type, toppings, etc.
    String getOrderDetails();
}
