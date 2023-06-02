package org.example;

import java.util.Scanner;

public class HomeScreen {
    public void display() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(ColorCodes.ANSI_PINK +"\n=*=*=*=*=*=*=*=*=*=*=*=*=* Welcome to DELI-cious! *=*=*=*=*=*=*=*=*=*=*=*=*=* \n"+ColorCodes.ANSI_RESET);
            System.out.println(ColorCodes.ORANGE+"1) Place a New Order");

            System.out.println("0) Exit"+ColorCodes.ANSI_RESET);
            System.out.print(ColorCodes.ANSI_YELLOW+"\nEnter your choice: "+ColorCodes.ANSI_RESET);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Order order = new Order();
                    OrderScreen orderScreen = new OrderScreen(order);
                    orderScreen.display();

                    if (order.getItems().isEmpty()) {
                        // No items in the order, go back to the Home Screen
                        System.out.println(ColorCodes.GREEN+"Order canceled or no items added. Returning to Home Screen."+ColorCodes.ANSI_RESET);
                        break;
                    }

                    boolean checkoutSuccessful = orderScreen.checkout();
                    if (checkoutSuccessful) {
                        // Continue the loop and show the Home Screen
                        break;
                    } else {
                        // Exit the application
                        System.out.println(ColorCodes.GREEN+"Exiting the application. Goodbye!"+ColorCodes.ANSI_RESET);
                        return;
                    }
                case 0:
                    System.out.println(ColorCodes.GREEN+"Exiting the application... Goodbye!"+ColorCodes.ANSI_RESET);
                    return;
                default:
                    System.out.println(ColorCodes.GREEN+"Invalid choice. Please try again."+ColorCodes.ANSI_RESET);
            }
        }
    }
}