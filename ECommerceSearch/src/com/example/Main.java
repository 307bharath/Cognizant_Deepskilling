package ECommerceSearch.src.com.example;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(3, "Laptop", "Electronics"),
            new Product(1, "Shirt", "Clothing"),
            new Product(2, "Book1", "Books")
        };

        // Linear Search (unsorted)
        //searching by product name
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter product name to search: ");
        String productName = sc.nextLine();
        sc.close();
        int idx = SearchUtils.linearSearch(products, productName);
        if (idx != -1) {
            System.out.println(" Linear Search: " + "Name:"+products[idx].getProductName()+
                               ", ID:"+products[idx].getProductId()+
                               ", Category:"+products[idx].getCategory());
        } else {
            System.out.println("Linear Search: Not found");
        }
        // Sort products by productID
        Arrays.sort(products, (a, b) -> Integer.compare(a.getProductId(), b.getProductId()));

        // Binary Search (sorted)
        idx = SearchUtils.binarySearch(products, productName);
        if (idx != -1) {
            System.out.println("Binary Search: " + "Name:"+products[idx].getProductName()+
                               ", ID:"+products[idx].getProductId()+
                               ", Category:"+products[idx].getCategory());
        } else {
            System.out.println("Binary Search: Not found");
        }
    }
}
