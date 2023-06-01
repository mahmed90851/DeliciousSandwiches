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

            // Validate the input
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid choice.");
                scanner.nextLine();
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Order order = new Order();
                    OrderScreen orderScreen = new OrderScreen(order);
                    orderScreen.display();
                    break;
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
