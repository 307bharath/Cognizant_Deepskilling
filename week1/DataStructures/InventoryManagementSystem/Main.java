package InventoryManagementSystem;
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Add products
        inventory.addProduct(new Product("1", "Laptop", 10, 50000));
        inventory.addProduct(new Product("2", "Mouse", 50, 500));
        inventory.addProduct(new Product("3", "Keyboard", 30, 1500));
        inventory.addProduct(new Product("4", "Monitor", 20, 12000));

        System.out.println("Added products to inventory");
        // Display all products
        System.out.println("Current Inventory:");   
        inventory.displayAllProducts();
        // Update product
        inventory.updateProduct(new Product("1", "Laptop", 8, 48000));
        System.out.println("Updated Laptop quantity to 8 and price to 48000");

        // Delete product
        inventory.deleteProduct("2");
        System.out.println("Deleted Mouse from inventory");

        // Display all products
        System.out.println("Current Inventory:");
        inventory.displayAllProducts();
    }
}
