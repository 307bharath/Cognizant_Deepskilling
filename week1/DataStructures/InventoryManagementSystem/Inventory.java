package InventoryManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void updateProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void deleteProduct(String productId) {
        products.remove(productId);
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }

    public void displayAllProducts() {
        for (Product p : products.values()) {
            System.out.println("ID: " + p.getProductId() + ", Name: " + p.getProductName() +
                               ", Qty: " + p.getQuantity() + ", Price: " + p.getPrice());
        }
    }
}