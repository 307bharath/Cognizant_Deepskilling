package SortingCustomerOrders;


public class Main {
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
            new Order("O1", "Alice", 2500),
            new Order("O2", "Bob", 1500),
            new Order("O3", "Charlie", 3500),
            new Order("O4", "Diana", 2000)
        };

        // Quick Sort
        OrderSorter.quickSort(orders, 0, orders.length - 1);
        System.out.println("\nOrders after Quick Sort:");
        for (Order o : orders) System.out.println(o);
    }
}