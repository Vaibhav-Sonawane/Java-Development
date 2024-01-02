import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Item {
    private String name;
    private int quantity;

    public Item(String name, int quantity)
    {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantity() 
    {
        return quantity;
    }

    public void setQuantity(int quantity) 
    {
        this.quantity = quantity;
    }
}

public class InventorySystem 
{
    private static Map<String, Item> inventory = new HashMap<>();

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        while (true) 
        {
            System.out.println("\nOptions:");
            System.out.println("1. Add Item");
            System.out.println("2. Update Item");
            System.out.println("3. View Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) 
            {
                case 1:
                    addItem(scanner);
                    break;
                case 2:
                    updateItem(scanner);
                    break;
                case 3:
                    viewInventory();
                    break;
                case 4:
                    System.out.println("Exiting inventory system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addItem(Scanner scanner) 
    {
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Item item = new Item(itemName, quantity);
        inventory.put(itemName, item);
        System.out.println(itemName + " with quantity " + quantity + " added to inventory.");
    }

    private static void updateItem(Scanner scanner) 
    {
        System.out.print("Enter item name to update: ");
        String itemName = scanner.nextLine();

        Item item = inventory.get(itemName);
        if (item != null) 
        {
            System.out.print("Enter new quantity: ");
            int newQuantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            item.setQuantity(newQuantity);
            System.out.println(itemName + " quantity updated to " + newQuantity + ".");
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    private static void viewInventory() 
    {
        System.out.println("Inventory:");
        for (Item item : inventory.values()) 
        {
            System.out.println(item.getName() + ": " + item.getQuantity());
        }
    }
}