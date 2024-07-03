import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Inventory {
    private Map<String, Integer> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void addItem(String itemName, int quantity) {
        if (items.containsKey(itemName)) {
            items.put(itemName, items.get(itemName) + quantity);
        } else {
            items.put(itemName, quantity);
        }
        System.out.println(quantity + "STARBOOK " + itemName + "(s) added to inventory.");
    }

    public void displayInventory() {
        if (items.isEmpty()) {
            System.out.println("Inventory is  empty.");
            return;
        }
        System.out.println("Inventory:");
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void sellItem(String itemName, int quantity) {
        if (items.containsKey(itemName)) {
            int availableQuantity = items.get(itemName);
            if (availableQuantity >= quantity) {
                items.put(itemName, availableQuantity - quantity);
                System.out.println(quantity + " " + itemName + "(s) sold.");
            } else {
                System.out.println("Insufficient quantity of " + itemName + " in inventory.");
            }
        } else {
            System.out.println("Item not found in inventory.");
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add item to inventory");
            System.out.println("2. Display inventory");
            System.out.println("3. Sell item");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    inventory.addItem(itemName, quantity);
                    break;
                case 2:
                    inventory.displayInventory();
                    break;
                case 3:
                    System.out.print("Enter item name to sell: ");
                    String itemToSell = scanner.nextLine();
                    System.out.print("Enter quantity to sell: ");
                    int quantityToSell = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    inventory.sellItem(itemToSell, quantityToSell);
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}

