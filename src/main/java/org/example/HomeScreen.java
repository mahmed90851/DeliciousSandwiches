package org.example;
import java.util.Scanner;

public class HomeScreen {
    public void display() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to DELI-cious!");
            System.out.println("1) Place a New Order");
            System.out.println("0) Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Order order = new Order();
                    OrderScreen orderScreen = new OrderScreen(order);
                    orderScreen.display();

                    if (order.getItems().isEmpty()) {
                        // No items in the order, go back to the Home Screen
                        System.out.println("Order canceled or no items added. Returning to Home Screen.");
                        break;
                    }

                    boolean checkoutSuccessful = orderScreen.checkout();
                    if (checkoutSuccessful) {
                        // Continue the loop and show the Home Screen
                        break;
                    } else {
                        // Exit the application
                        System.out.println("Exiting the application. Goodbye!");
                        return;
                    }

                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
