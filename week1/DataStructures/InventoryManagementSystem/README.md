# Inventory Management System

This project is a simple inventory management system for a warehouse, demonstrating efficient data storage and retrieval using appropriate data structures in Java.

---

## 1. Why Data Structures and Algorithms Matter

Efficient data structures and algorithms are essential for handling large inventories because:
- They enable **fast searching, updating, and deleting** of products.
- They help manage **memory efficiently**.
- They ensure the system can **scale** as the number of products grows.

**Suitable Data Structures:**
- **ArrayList:** Good for small inventories or when order matters, but slow for searching/updating by ID.
- **HashMap:** Best for large inventories when you need fast access by product ID (constant time for add, update, delete).

---

## 2. Setup

Create a new Java project, e.g., `InventoryManagementSystem`.

---

## 3. Implementation

### Product.java

```java
package com.example;

public class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters...
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setProductName(String productName) { this.productName = productName; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }
}
```

### Inventory.java

```java
package com.example;

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
```

### Main.java

```java
package com.example;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Add products
        inventory.addProduct(new Product("1", "Laptop", 10, 50000));
        inventory.addProduct(new Product("2", "Mouse", 50, 500));

        // Update product
        inventory.updateProduct(new Product("1", "Laptop", 8, 48000));

        // Delete product
        inventory.deleteProduct("2");

        // Display all products
        inventory.displayAllProducts();
    }
}
```

---

## 4. Analysis

**Time Complexity (using HashMap):**
- **Add:** O(1)
- **Update:** O(1)
- **Delete:** O(1)
- **Search:** O(1)

**Optimization:**
- Use `HashMap` for fast access by product ID.
- For range queries or sorted data, consider `TreeMap`.
- For concurrent access, use `ConcurrentHashMap`.

---
