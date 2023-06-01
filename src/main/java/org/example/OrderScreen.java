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
            System.out.println("0) Cancel Order");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Call the method to add a sandwich to the order
                    addSandwich();
                    break;
                case 2:
                    // Call the method to add a drink to the order
                    addDrink();
                    break;
                case 3:
                    // Call the method to add chips to the order
                    addChips();
                    break;
                case 4:
                    // Call the method to proceed to checkout
                    checkout();
                    break;
                case 0:
                    System.out.println("Order canceled.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addSandwich() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for sandwich details
        System.out.println("Add Sandwich");
        int breadChoice = validateInput(scanner, "Select bread type (1. White, 2. Wheat, 3. Rye, 4. Wrap): ");

        int sizeChoice =validateInput(scanner,"Enter sandwich size (4, 8, or 12 inches): ");


        // Prompt the user for toppings
        System.out.println("Select toppings (separate with commas):");
        System.out.println("Available meat toppings: Steak, Ham, Salami, Roast Beef, Chicken, Bacon");
        System.out.println("Available toppings: Lettuce, Peppers, Onions, Tomatoes, Jalepenos, Cucumbers, Pickles, Guacamole, Mushrooms");
        String toppingsInput = scanner.nextLine();
        String[] toppingsArray = toppingsInput.split(",");


        // Prompt the user for sauces
        System.out.println("Select sauces (separate with comma, e.g., MAYO,MUSTARD): ");
        String saucesInput = scanner.nextLine();
        String[] saucesArray = saucesInput.split(",");



        // Create a new Sandwich object
        BreadType breadType;
        switch (breadChoice) {
            case 1 :
                breadType = BreadType.WHITE;
                break;
            case 2:
                breadType = BreadType.WHEAT;
                break;
            case 3:
                breadType = BreadType.RYE;
                break;
            case 4:
                breadType = BreadType.WRAP;
                break;
            default:
                System.out.println("Invalid bread choice. Sandwich not added.");
                return;
        }
        Bread bread = new Bread(breadType.getName(), breadType.getPrice());

        SandwichSize sandwichSize;
        switch (sizeChoice) {
            case 4:
                sandwichSize = SandwichSize.FOUR_INCH;
                break;
            case 8:
                sandwichSize = SandwichSize.EIGHT_INCH;
                break;
            case 12:
                sandwichSize = SandwichSize.TWELVE_INCH;
                break;
            default:
                System.out.println("Invalid size choice. Sandwich not added.");
                return;
        }
        Sandwich sandwich = new Sandwich(bread, sandwichSize);

        // Add toppings to the sandwich
        for (String toppingName : toppingsArray) {
            Topping topping;
            switch (toppingName.toUpperCase()) {
                case "LETTUCE":
                    topping = Topping.LETTUCE;
                    break;
                case "PEPPERS":
                    topping = Topping.PEPPERS;
                    break;
                case "ONIONS":
                    topping = Topping.ONIONS;
                    break;
                case "TOMATOES":
                    topping = Topping.TOMATOES;
                    break;
                case "JALEPENOS":
                    topping = Topping.JALEPENOS;
                    break;
                case "CUCUMBERS":
                    topping = Topping.CUCUMBERS;
                    break;
                case "PICKLES":
                    topping = Topping.PICKLES;
                    break;
                case "GUACAMOLE":
                    topping = Topping.GUACAMOLE;
                    break;
                case "MUSHROOMS":
                    topping = Topping.MUSHROOMS;
                    break;
                case "STEAK":
                    topping = Topping.STEAK;
                    break;
                case "HAM":
                    topping = Topping.HAM;
                    break;
                case "SALAMI":
                    topping = Topping.SALAMI;
                    break;
                case "ROAST BEEF":
                    topping = Topping.ROAST_BEEF;
                    break;
                case "CHICKEN":
                    topping = Topping.CHICKEN;
                    break;
                case "BACON":
                    topping = Topping.BACON;
                    break;
                case "AMERICAN CHEESE":
                    topping = Topping.AMERICAN_CHEESE;
                    break;
                case "PROVOLONE CHEESE":
                    topping = Topping.PROVOLONE_CHEESE;
                    break;
                case "CHEDDAR CHEESE":
                    topping = Topping.CHEDDAR_CHEESE;
                    break;
                case "SWISS CHEESE":
                    topping = Topping.SWISS_CHEESE;
                    break;
                default:
                    System.out.println("Invalid topping choice: " + toppingName);
                    continue;
            }
            sandwich.addTopping(topping);
        }

        // Add sauces to the sandwich
        for (String sauceName : saucesArray) {
            SauceType sauceType;
            switch (sauceName.toUpperCase()) {
                case "MAYO":
                    sauceType = SauceType.MAYO;
                    break;
                case "MUSTARD":
                    sauceType = SauceType.MUSTARD;
                    break;
                case "KETCHUP":
                    sauceType = SauceType.KETCHUP;
                    break;
                case "RANCH":
                    sauceType = SauceType.RANCH;
                    break;
                case "THOUSAND ISLANDS":
                    sauceType = SauceType.THOUSAND_ISLANDS;
                    break;
                case "VINAIGRETTE":
                    sauceType = SauceType.VINAIGRETTE;
                    break;
                default:
                    System.out.println("Invalid sauce choice: " + sauceName);
                    continue;
            }
            Sauce sauce = new Sauce(sauceType.getName());
            sandwich.addSauce(sauce);
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
            case 1:
                type = DrinkType.SODA;
                break;
            case 2:
                type = DrinkType.WATER;
                break;
            case 3:
                type = DrinkType.JUICE;
                break;
            case 4:
                type = DrinkType.TEA;
                break;
            case 5:
                type = DrinkType.COFFEE;
                break;
            default:
                System.out.println("Invalid type choice. Drink not added.");
                return;
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
            case 1:
                chipType = ChipType.REGULAR;
                break;
            case 2:
                chipType = ChipType.BBQ;
                break;
            case 3:
                chipType = ChipType.SOUR_CREAM_AND_ONION;
                break;
            case 4:
                chipType = ChipType.SALTED;
                break;
            case 5:
                chipType = ChipType.CHEESE;
                break;
            case 6:
                chipType = ChipType.SPICY;
                break;
            default:
                System.out.println("Invalid chip choice. Chips not added.");
                return;
        }
        Chip chips = new Chip(chipType);

        // Add the chips to the order
        order.addOrderable(chips);

        System.out.println("Chips added to the order.");
    }

    private void checkout() {
        System.out.println("Checkout");
        System.out.println("Order Details:");

        System.out.println("Number of items in the order: " + order.getItems().size());
        for (OrderableItem item : order.getItems()) {
            System.out.println(item.getOrderDetails());
        }

        System.out.printf("Total Price: $%.2f%n", order.getTotalPrice());

        System.out.println("Thank you for your order!");

        String folderPath = "ReceiptsFolder";
        String receiptContent = order.getReceipt(); // Replace with the actual receipt content

        ReceiptManager receiptManager = new ReceiptManager(folderPath);
        receiptManager.createReceipt(receiptContent);

        System.exit(0);

    }
    private int validateInput(Scanner scanner, String message) {
        System.out.print(message);

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid choice.");
            scanner.nextLine();
        }

        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}
