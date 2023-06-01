package org.example;

import java.util.Scanner;


public class OrderScreen {

    private Order order;

    public OrderScreen(Order order) {
        this.order = order;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Order Screen");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("5) Return to Home Screen");
            System.out.println("0) Cancel Order");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 ->
                    // Call the method to add a sandwich to the order
                        addSandwich();
                case 2 ->
                    // Call the method to add a drink to the order
                        addDrink();
                case 3 ->
                    // Call the method to add chips to the order
                        addChips();
                case 4 ->
                    // Call the method to proceed to checkout
                        checkout();
                case 5 -> {
                    System.out.println("Returning to Home Screen.");
                    return; // Return to Home Screen
                }
                case 0 -> {
                    System.out.println("Order canceled.");
                    return; // Cancel Order
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private void addSandwich() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for sandwich details
        System.out.println("Add Sandwich");
        System.out.print("Select bread type (1. White, 2. Wheat, 3. Rye, 4. Wrap): ");
        int breadChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter sandwich size (4, 8, or 12 inches): ");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();

        //Display the available toppings
        System.out.println("Available Toppings:");
        for (Topping topping : Topping.values()) {
            System.out.println("- " + topping.getName());
        }

        // Prompt the user for toppings
        System.out.println("Select toppings (separate with comma, e.g., LETTUCE,TOMATOES): ");
        String toppingsInput = scanner.nextLine();
        String[] toppingsArray = toppingsInput.split(",");

        // Display the available sauces
        System.out.println("Available sauces:");
        SauceType[] sauceTypes = SauceType.values();
        for (int i = 0; i < sauceTypes.length; i++) {
            System.out.println((i + 1) + ". " + sauceTypes[i].getName());
        }

        // Prompt the user for sauces
        System.out.println("Select sauces (separate with comma, e.g., MAYO,MUSTARD): ");
        String saucesInput = scanner.nextLine();
        String[] saucesArray = saucesInput.split(",");

        // Prompt the user if they want the sandwich toasted
        System.out.print("Do you want the sandwich toasted? (Yes/No): ");
        String toastedChoice = scanner.nextLine();
        boolean toasted = toastedChoice.equalsIgnoreCase("yes");

        // Prompt the user if they want extra cheese
        System.out.print("Do you want extra cheese? (Yes/No): ");
        String extraCheeseChoice = scanner.nextLine();
        boolean extraCheese = extraCheeseChoice.equalsIgnoreCase("yes");

        // Prompt the user if they want extra meat
        System.out.print("Do you want extra meat? (Yes/No): ");
        String extraMeatChoice = scanner.nextLine();
        boolean extraMeat = extraMeatChoice.equalsIgnoreCase("yes");

        // Prompt the user if they want to add sides
        System.out.print("Do you want to add sides? (Yes/No): ");
        String addSidesChoice = scanner.nextLine();
        boolean addSides = addSidesChoice.equalsIgnoreCase("yes");

        // Create a new Sandwich object
        BreadType breadType;
        switch (breadChoice) {
            case 1 -> breadType = BreadType.WHITE;
            case 2 -> breadType = BreadType.WHEAT;
            case 3 -> breadType = BreadType.RYE;
            case 4 -> breadType = BreadType.WRAP;
            default -> {
                System.out.println("Invalid bread choice. Sandwich not added.");
                return;
            }
        }
        Bread bread = new Bread(breadType.getName(), breadType.getPrice());

        SandwichSize sandwichSize;
        switch (sizeChoice) {
            case 4 -> sandwichSize = SandwichSize.FOUR_INCH;
            case 8 -> sandwichSize = SandwichSize.EIGHT_INCH;
            case 12 -> sandwichSize = SandwichSize.TWELVE_INCH;
            default -> {
                System.out.println("Invalid size choice. Sandwich not added.");
                return;
            }
        }
        Sandwich sandwich = new Sandwich(bread, sandwichSize);
        sandwich.setToasted(toasted);

        // Add toppings to the sandwich
        for (String toppingName : toppingsArray) {
            Topping topping;
            switch (toppingName.toUpperCase()) {
                case "LETTUCE" -> topping = Topping.LETTUCE;
                case "PEPPERS" -> topping = Topping.PEPPERS;
                case "ONIONS" -> topping = Topping.ONIONS;
                case "TOMATOES" -> topping = Topping.TOMATOES;
                case "JALEPENOS" -> topping = Topping.JALEPENOS;
                case "CUCUMBERS" -> topping = Topping.CUCUMBERS;
                case "PICKLES" -> topping = Topping.PICKLES;
                case "GUACAMOLE" -> topping = Topping.GUACAMOLE;
                case "MUSHROOMS" -> topping = Topping.MUSHROOMS;
                case "STEAK" -> topping = Topping.STEAK;
                case "HAM" -> topping = Topping.HAM;
                case "SALAMI" -> topping = Topping.SALAMI;
                case "ROAST BEEF" -> topping = Topping.ROAST_BEEF;
                case "CHICKEN" -> topping = Topping.CHICKEN;
                case "BACON" -> topping = Topping.BACON;
                case "AMERICAN CHEESE" -> topping = Topping.AMERICAN_CHEESE;
                case "PROVOLONE CHEESE" -> topping = Topping.PROVOLONE_CHEESE;
                case "CHEDDAR CHEESE" -> topping = Topping.CHEDDAR_CHEESE;
                case "SWISS CHEESE" -> topping = Topping.SWISS_CHEESE;
                default -> {
                    System.out.println("Invalid topping choice: " + toppingName);
                    continue;
                }
            }
            sandwich.addTopping(topping);
        }

        // Add sauces to the sandwich
        for (String sauceName : saucesArray) {
            SauceType sauceType;
            switch (sauceName.toUpperCase()) {
                case "MAYO" -> sauceType = SauceType.MAYO;
                case "MUSTARD" -> sauceType = SauceType.MUSTARD;
                case "KETCHUP" -> sauceType = SauceType.KETCHUP;
                case "RANCH" -> sauceType = SauceType.RANCH;
                case "THOUSAND ISLANDS" -> sauceType = SauceType.THOUSAND_ISLANDS;
                case "VINAIGRETTE" -> sauceType = SauceType.VINAIGRETTE;
                default -> {
                    System.out.println("Invalid sauce choice: " + sauceName);
                    continue;
                }
            }
            Sauce sauce = new Sauce(sauceType.getName());
            sandwich.addSauce(sauce);
        }

        // Add extra cheese if selected
        if (extraCheese) {
            Topping extraCheeseTopping = Topping.EXTRA_CHEESE;
            sandwich.addTopping(extraCheeseTopping);
        }

        // Add extra meat if selected
        if (extraMeat) {
            Topping extraMeatTopping = Topping.EXTRA_MEAT;
            sandwich.addTopping(extraMeatTopping);
        }

        // Add sides if selected
        if (addSides) {
            System.out.print("Enter side options (separate with comma, e.g., SAUCE,AU JUS): ");
            String sidesInput = scanner.nextLine();
            String[] sidesArray = sidesInput.split(",");
            for (String sideName : sidesArray) {
                SauceType sideType;
                switch (sideName.toUpperCase()) {
                    case "SAUCE" -> sideType = SauceType.SIDE_SAUCE;
                    case "AU JUS" -> sideType = SauceType.SIDE_AU_JUS;
                    default -> {
                        System.out.println("Invalid side choice: " + sideName);
                        continue;
                    }
                }
                Sauce side = new Sauce(sideType.getName());
                sandwich.addSauce(side);
            }
        }

        // Add the sandwich to the order
        order.addOrderable(sandwich);

        System.out.println("Sandwich added to the order.");
    }


    private void addDrink() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for drink details
        System.out.println("Add Drink");
        System.out.print("Select drink type (1. Soda, 2. Water, 3. Juice, 4. Tea, 5. Coffee): ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Select drink size (1. Small, 2. Medium, 3. Large): ");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();

        // Create a new Drink object
        DrinkType type;
        switch (typeChoice) {
            case 1 -> type = DrinkType.SODA;
            case 2 -> type = DrinkType.WATER;
            case 3 -> type = DrinkType.JUICE;
            case 4 -> type = DrinkType.TEA;
            case 5 -> type = DrinkType.COFFEE;
            default -> {
                System.out.println("Invalid type choice. Drink not added.");
                return;
            }
        }

        DrinkSize size;
        switch (sizeChoice) {
            case 1:
                size = DrinkSize.SMALL;
                break;
            case 2:
                size = DrinkSize.MEDIUM;
                break;
            case 3:
                size = DrinkSize.LARGE;
                break;
            default:
                System.out.println("Invalid size choice. Drink not added.");
                return;
        }

        Drink drink = new Drink(type, size);

        // Add the drink to the order
        order.addOrderable(drink);

        System.out.println("Drink added to the order.");
    }


    private void addChips() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for chip details
        System.out.println("Add Chips");
        System.out.print("Select chip type (1. Regular, 2. BBQ, 3. Sour Cream & Onion, 4. Salted, 5. Cheese, 6. Spicy): ");
        int chipChoice = scanner.nextInt();
        scanner.nextLine();

        // Create a new Chips object
        ChipType chipType;
        switch (chipChoice) {
            case 1 -> chipType = ChipType.REGULAR;
            case 2 -> chipType = ChipType.BBQ;
            case 3 -> chipType = ChipType.SOUR_CREAM_AND_ONION;
            case 4 -> chipType = ChipType.SALTED;
            case 5 -> chipType = ChipType.CHEESE;
            case 6 -> chipType = ChipType.SPICY;
            default -> {
                System.out.println("Invalid chip choice. Chips not added.");
                return;
            }
        }
        Chip chips = new Chip(chipType);

        // Add the chips to the order
        order.addOrderable(chips);

        System.out.println("Chips added to the order.");
    }

    public boolean checkout() {
        System.out.println("Checkout");
        System.out.println("Order Details:");

        System.out.println("Number of items in the order: " + order.getItems().size());
        for (OrderableItem item : order.getItems()) {
            System.out.println(item.getOrderDetails());
        }

        System.out.printf("Total Price: $%.2f%n", order.getTotalPrice());

        System.out.println("Thank you for your order!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Confirm your order (Y/N): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("Y")) {
            String folderPath = "ReceiptsFolder";
            String receiptContent = order.getReceipt(); // Replace with the actual receipt content

            ReceiptManager receiptManager = new ReceiptManager(folderPath);
            receiptManager.createReceipt(receiptContent);

            // Clear the order for the next transaction
            order.clear();

             // Checkout successful
        } else {
            System.out.println("Order canceled.");
            return false; // Checkout canceled
        }
        return true;
    }
}