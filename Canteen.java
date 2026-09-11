import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu data
        String[] itemNames = {"Burger", "Pizza", "Pasta", "Sandwich", "Milk Tea"};
        double[] itemPrices = {80.00, 120.00, 100.00, 70.00, 90.00};

        // Running totals for the whole transaction
        int totalItemsPurchased = 0;
        double totalBeforeDiscount = 0.0;
        double totalDiscount = 0.0;
        double totalFinalAmount = 0.0;

        displayMenu(itemNames, itemPrices);

        char orderAgain;
        do { 
            System.out.print("Enter item number: ");
            int itemNumber = scanner.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            boolean validItem = itemNumber >= 1 && itemNumber <= itemNames.length;
            boolean validQuantity = quantity >= 1 && quantity <= 10;

            if (!validItem || !validQuantity) {
                System.out.println("\nInvalid order! Please enter a valid item number and quantity.\n");
            } else {
                System.out.print("Are you a student? (Y/N): ");
                char studentAnswer = scanner.next().charAt(0);
                boolean isStudent = (studentAnswer == 'Y' || studentAnswer == 'y');
                
                double price = itemPrices[itemNumber - 1];
                double subtotal = price * quantity;

                System.out.println();
                System.out.printf("Subtotal: $%.2f%n", subtotal);
                System.out.printf("Discount: $%.2f%n", discount);
                System.out.printf("Order total: $%.2f%n", orderTotal);

                // Update running totals
                totalItemsPurchased += quantity;
                totalBeforeDiscount += subtotal;
                totalDiscount += discount;
                totalFinalAmount += orderTotal;
            }

            System.out.println();
            System.out.print("Do you want to order again? (Y/N): ");
            orderAgain = scanner.next().charAt(0);
            System.out.println();

        } while (orderAgain == 'Y' || orderAgain == 'y');

        displaySummary(totalItemsPurchased, totalBeforeDiscount, totalDiscount, totalFinalAmount);

        scanner.close();
    }

    // Displays the canteen menu
    private static void displayMenu(String[] itemNames, double[] itemPrices) {
        System.out.println("=====   M E N U   =====");
        for (int i = 0; i < itemNames.length; i++) {
            System.out.printf("%d. %-9s- $%.2f%n", (i + 1), itemNames[i], itemPrices[i]);
        }
        System.out.println();
    }

    // Displays the final order summary
    private static void displaySummary(int totalItems, double totalBeforeDiscount,
                                        double totalDiscount, double finalAmount) {
        System.out.println("===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalItems);
        System.out.printf("Total before discount: $%.2f%n", totalBeforeDiscount);
        System.out.printf("Total discount: $%.2f%n", totalDiscount);
        System.out.printf("Final amount: $%.2f%n", finalAmount);
        System.out.println("Thank you for ordering!");
    }
}