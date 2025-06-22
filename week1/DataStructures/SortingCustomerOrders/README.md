# Sorting Customer Orders

This project demonstrates sorting customer orders by their total price using Bubble Sort and Quick Sort algorithms in Java.

---

## 1. Sorting Algorithms Overview

- **Bubble Sort:**  
  Repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.  
  - **Time Complexity:** O(n²)
- **Insertion Sort:**  
  Builds the sorted array one item at a time by inserting elements into their correct position.  
  - **Time Complexity:** O(n²)
- **Quick Sort:**  
  Divides the array into partitions using a pivot, recursively sorts the partitions.  
  - **Time Complexity:** O(n log n) average, O(n²) worst case
- **Merge Sort:**  
  Divides the array into halves, recursively sorts and merges them.  
  - **Time Complexity:** O(n log n)

---

## 2. Order Class

```java
package InventoryManagementSystem;

public class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotalPrice() { return totalPrice; }

    @Override
    public String toString() {
        return "OrderID: " + orderId + ", Customer: " + customerName + ", Total: " + totalPrice;
    }
}
```

---

## 3. Bubble Sort and Quick Sort Implementation

```java
package InventoryManagementSystem;

public class OrderSorter {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (orders[j].getTotalPrice() > orders[j+1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j+1];
                    orders[j+1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}
```

---

## 4. Main Class to Test Sorting

```java
package InventoryManagementSystem;

public class MainOrders {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("O1", "Bharath", 2500),
            new Order("O2", "Geethu", 1500),
            new Order("O3", "Ganesh", 3500),
            new Order("O4", "Ramesh", 2000)
        };

        System.out.println("Original Orders:");
        for (Order o : orders) System.out.println(o);

        // Bubble Sort
        OrderSorter.bubbleSort(orders);
        System.out.println("\nOrders after Bubble Sort:");
        for (Order o : orders) System.out.println(o);

        // Shuffle for demonstration (or recreate array)
        orders = new Order[]{
            new Order("O1", "Bharath", 2500),
            new Order("O2", "Geethu", 1500),
            new Order("O3", "Ganesh", 3500),
            new Order("O4", "Ramesh", 2000)
        };

        // Quick Sort
        OrderSorter.quickSort(orders, 0, orders.length - 1);
        System.out.println("\nOrders after Quick Sort:");
        for (Order o : orders) System.out.println(o);
    }
}
```

---

## 5. Analysis

- **Bubble Sort:** O(n²) — inefficient for large datasets.
- **Quick Sort:** O(n log n) average — much faster for large datasets.
- **Why Quick Sort is Preferred:**  
  Quick Sort is generally preferred because it is much faster for large lists due to its divide-and-conquer approach, while Bubble Sort is only suitable for very small or nearly sorted lists.

---
