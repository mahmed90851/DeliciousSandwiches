package org.example;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void displayHomeScreen() {
        System.out.println("Welcome to DELI-cious!");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
    }

    public void displayOrderScreen() {
        System.out.println("Order Screen:");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");
    }

    public void displayAddSandwichScreen() {
        System.out.println("Add Sandwich:");
        System.out.println("Select your bread:");
        // Display bread options
        System.out.println("Select sandwich size:");
        // Display size options
        System.out.println("Select toppings:");
        // Display topping options
        System.out.println("Select sauces:");
        // Display sauce options
        System.out.println("Would you like the sandwich toasted? (Y/N)");
    }

    public void displayAddDrinkScreen() {
        System.out.println("Add Drink:");
        System.out.println("Select drink size:");
        // Display size options
        System.out.println("Select drink flavor:");
        // Display flavor options
    }

    public void displayAddChipsScreen() {
        System.out.println("Add Chips:");
        // Display chip options
    }

    public void displayCheckoutScreen(double totalPrice, String orderDetails) {
        System.out.println("Checkout:");
        System.out.println("Order Details:");
        System.out.println(orderDetails);
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("1) Confirm");
        System.out.println("2) Cancel");
    }

    public int getInput() {
        return scanner.nextInt();
    }

    public void handleUserInput(int input) {
        switch (input) {
            case 0:
                System.out.println("Exiting the application. Goodbye!");
                break;
            case 1:
                displayOrderScreen();
                int orderInput = getInput();
                handleOrderInput(orderInput);
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }
    }

    public void handleOrderInput(int input) {
        switch (input) {
            case 0:
                System.out.println("Order cancelled.");
                displayHomeScreen();
                break;
            case 1:
                displayAddSandwichScreen();
                int sandwichInput = getInput();
                // Handle add sandwich input
                break;
            case 2:
                displayAddDrinkScreen();
                int drinkInput = getInput();
                // Handle add drink input
                break;
            case 3:
                displayAddChipsScreen();
                int chipsInput = getInput();
                // Handle add chips input
                break;
            case 4:
                double totalPrice = 0.0; // Calculate the total price
                String orderDetails = ""; // Generate the order details
                displayCheckoutScreen(totalPrice, orderDetails);
                int checkoutInput = getInput();
                handleCheckoutInput(checkoutInput);
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }
    }

    public void handleCheckoutInput(int input) {
        switch (input) {
            case 1:
                System.out.println("Order confirmed. Thank you!");
                displayHomeScreen();
                break;
            case 2:
                System.out.println("Order cancelled.");
                displayHomeScreen();
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                displayCheckoutScreen(totalPrice, orderDetails);
                break;
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
