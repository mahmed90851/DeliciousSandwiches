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
            System.out.println(ColorCodes.ANSI_PINK + "\n*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*= Order Screen *=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=" + ColorCodes.ANSI_RESET);
            System.out.println(ColorCodes.TEXT_BLUE + "\n1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("5) Return to Home Screen");
            System.out.println("0) Cancel Order" + ColorCodes.ANSI_RESET);
            System.out.print(ColorCodes.TEXT_YELLOW + "\nEnter your choice: " + ColorCodes.ANSI_RESET);
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
                    System.out.println(ColorCodes.GREEN + "Returning to Home Screen..." + ColorCodes.ANSI_RESET);
                    return; // Return to Home Screen
                }
                case 0 -> {
                    System.out.println(ColorCodes.GREEN + "Order canceled." + ColorCodes.ANSI_RESET);
                    return; // Cancel Order
                }
                default ->
                        System.out.println(ColorCodes.TEXT_RED + "Invalid choice. Please try again." + ColorCodes.ANSI_RESET);
            }
        }
    }

    private void addSandwich() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for sandwich details
        System.out.println(ColorCodes.TEXT_PURPLE + "Add Sandwich" + ColorCodes.ANSI_RESET);
        System.out.println(ColorCodes.ANSI_PINK + "\nSelect bread type :\n" + ColorCodes.ANSI_RESET + ColorCodes.ANSI_BLUE +
                "(Only type the number)\n" + ColorCodes.ANSI_YELLOW +
                "1. White\n" +
                "2. Wheat\n" +
                "3. Rye\n" +
                "4. Wrap\n" + ColorCodes.ANSI_RESET);
        int breadChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.println(ColorCodes.ANSI_PINK + "Enter sandwich size:\n" +
                "(4, 8, or 12 inches): ");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();

        // Prompt the user for toppings
        System.out.println("\nSelect Toppings:\n" + "(Separate with comma,)" + ColorCodes.ANSI_RESET);
        System.out.print(ColorCodes.TEXT_PURPLE + "*+*+* VEGETABLE *+*+*\n" + ColorCodes.ANSI_RESET);
        System.out.print(ColorCodes.ANSI_YELLOW +
                "- LETTUCE\n" +
                "- PEPPERS\n" +
                "- ONIONS\n" +
                "- TOMATOES\n" +
                "- JALEPENOS\n" +
                "- CUCUMBERS\n" +
                "- PICKLES\n" +
                "- GUACAMOLE\n" +
                "- MUSHROOMS\n" + ColorCodes.ANSI_RESET);

        System.out.println(ColorCodes.TEXT_PURPLE + "\n*+*+*+ MEAT +*+*+*" + ColorCodes.ANSI_RESET);
        System.out.println(ColorCodes.ANSI_YELLOW +
                "- STEAK\n" +
                "- HAM\n" +
                "- SALAMI\n" +
                "- ROAST BEEF\n" +
                "- CHICKEN\n"+
                "- BACON\n");

        System.out.println(ColorCodes.TEXT_PURPLE + "*+*+*+ CHEESE +*+*+*" + ColorCodes.ANSI_RESET);
        System.out.println(ColorCodes.ANSI_YELLOW +
                "- AMERICAN CHEESE\n" +
                "- PROVOLONE CHEESE\n" +
                "- CHEDDAR CHEESE\n" +
                "- SWISS CHEESE");

        String toppingsInput = scanner.nextLine();
        String[] toppingsArray = toppingsInput.split(",");

        // Prompt the user for sauces
        System.out.println(ColorCodes.ANSI_PINK + "\nSelect sauces:\n" +
                "(Separate with comma,)\n" + ColorCodes.ANSI_RESET + ColorCodes.ANSI_YELLOW +
                "- MAYO\n" +
                "- MUSTARD\n" +
                "- KETCHUP\n" +
                "- RANCH\n" +
                "- THOUSAND ISLANDS\n" +
                "- VINAIGRETTE" + ColorCodes.ANSI_RESET);
        String saucesInput = scanner.nextLine();
        String[] saucesArray = saucesInput.split(",");

        // Prompt the user if they want the sandwich toasted
        System.out.print(ColorCodes.TEXT_PURPLE + "\nDo you want the sandwich toasted? (Yes/No): ");
        String toastedChoice = scanner.nextLine();
        boolean toasted = toastedChoice.equalsIgnoreCase("yes");

        // Prompt the user if they want extra cheese
        System.out.print("\nDo you want extra cheese? (Yes/No): ");
        String extraCheeseChoice = scanner.nextLine();
        boolean extraCheese = extraCheeseChoice.equalsIgnoreCase("yes");

        // Prompt the user if they want extra meat
        System.out.print("\nDo you want extra meat? (Yes/No): ");
        String extraMeatChoice = scanner.nextLine();
        boolean extraMeat = extraMeatChoice.equalsIgnoreCase("yes");

        // Prompt the user if they want to add sides
        System.out.print("\nDo you want to add sides? (Yes/No): " + ColorCodes.ANSI_RESET);
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
                System.out.println(ColorCodes.TEXT_RED + "\nInvalid bread choice. Sandwich not added." + ColorCodes.ANSI_RESET);
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
                System.out.println(ColorCodes.TEXT_RED + "\nInvalid size choice. Sandwich not added." + ColorCodes.ANSI_RESET);
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
                    System.out.println(ColorCodes.TEXT_RED + "\nInvalid topping choice: " + toppingName + ColorCodes.ANSI_RESET);
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
                    System.out.println(ColorCodes.TEXT_RED + "\nInvalid sauce choice: " + sauceName + ColorCodes.ANSI_RESET);
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
            System.out.print(ColorCodes.ANSI_PINK+"\nEnter side options:\n" +
                    "(Separate with comma,)\n" +ColorCodes.ANSI_RESET+ColorCodes.ANSI_YELLOW+
                    "- SAUCE\n" +
                    "- AU JUS\n"+ColorCodes.ANSI_RESET);
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

        System.out.println(ColorCodes.TEXT_PURPLE + "\nSandwich added to the order." + ColorCodes.ANSI_RESET);
    }


    private void addDrink() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for drink details
        System.out.println(ColorCodes.TEXT_PURPLE+ "Add Drink"+ColorCodes.ANSI_RESET);
        System.out.println(ColorCodes.TEXT_CYAN+"\nSelect drink type:\n" +ColorCodes.ANSI_RESET+ColorCodes.ANSI_YELLOW+
                "1. Soda\n" +
                "2. Water\n" +
                "3. Juice\n" +
                "4. Tea\n" +
                "5. Coffee"+ColorCodes.ANSI_RESET);
        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.println(ColorCodes.TEXT_CYAN+"Select drink size:\n" +ColorCodes.ANSI_RESET+ColorCodes.ANSI_YELLOW+
                "1. Small\n" +
                "2. Medium\n" +
                "3. Large"+ColorCodes.ANSI_RESET);
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
                System.out.println(ColorCodes.TEXT_RED + "\nInvalid type choice. Drink not added." + ColorCodes.ANSI_RESET);
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
                System.out.println(ColorCodes.TEXT_RED + "\nInvalid size choice. Drink not added." + ColorCodes.ANSI_RESET);
                return;
        }

        Drink drink = new Drink(type, size);

        // Add the drink to the order
        order.addOrderable(drink);

        System.out.println(ColorCodes.TEXT_PURPLE + "\nDrink added to the order." + ColorCodes.ANSI_RESET);
    }


    private void addChips() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for chip details
        System.out.println(ColorCodes.TEXT_PURPLE + "Add Chips"+ColorCodes.ANSI_RESET);
        System.out.println(ColorCodes.TEXT_CYAN+"\nSelect chip type:\n" +ColorCodes.ANSI_RESET+ColorCodes.ANSI_YELLOW+
                "1. Regular\n" +
                "2. BBQ\n"+
                "3. Sour Cream & Onion\n" +
                "4. Salted\n" +
                "5. Cheese\n" +
                "6. Spicy"+ColorCodes.ANSI_RESET);
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
                System.out.println(ColorCodes.TEXT_RED + "\nInvalid chip choice. Chips not added." + ColorCodes.ANSI_RESET);
                return;
            }
        }
        Chip chips = new Chip(chipType);

        // Add the chips to the order
        order.addOrderable(chips);

        System.out.println(ColorCodes.TEXT_PURPLE + "\nChips added to the order." + ColorCodes.ANSI_RESET);
    }

    public boolean checkout() {
        System.out.println(ColorCodes.TEXT_CYAN + "\n*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*= Checkout =*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=* " + ColorCodes.ANSI_RESET);
        System.out.println(ColorCodes.ANSI_YELLOW + "Order Details:" + ColorCodes.ANSI_RESET);

        // Debugging statements
        System.out.println(ColorCodes.TEXT_YELLOW + "\nNumber of items in the order: " + order.getItems().size());
        for (OrderableItem item : order.getItems()) {
            System.out.println(item.getOrderDetails());
        }

        System.out.printf("Total Price: $%.2f%n", order.getTotalPrice());

        // Perform any additional checkout logic, such as payment processing or generating a receipt file
        Scanner scanner = new Scanner(System.in);
        System.out.print(ColorCodes.TEXT_PURPLE+"Confirm your order (Y/N): "+ColorCodes.ANSI_RESET);
        String confirmation = scanner.nextLine();

        System.out.println(ColorCodes.GREEN + "\nThank you for your order!" + ColorCodes.ANSI_RESET);



        if (confirmation.equalsIgnoreCase("Y")) {
            String folderPath = "ReceiptsFolder";
            String receiptContent = order.getReceipt(); // Replace with the actual receipt content

            ReceiptManager receiptManager = new ReceiptManager(folderPath);
            receiptManager.createReceipt(receiptContent);

            // Clear the order for the next transaction
            order.clear();

            // Checkout successful
        } else {
            System.out.println(ColorCodes.ORANGE+"Order canceled."+ColorCodes.ANSI_RESET);
            return false; // Checkout canceled
        }
        return true;
    }
}
