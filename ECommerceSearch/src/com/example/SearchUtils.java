package ECommerceSearch.src.com.example;

public class SearchUtils {
    // Linear Search
    public static int linearSearch(Product[] products, String targetName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equals(targetName)) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search (array must be sorted by productId)
    public static int binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductName().equals(targetName)) {
                return mid;
            } else if (products[mid].getProductName().compareTo(targetName) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
/*
Analysis:
Linear Search:

Time Complexity: O(n) in worst and average cases, O(1) in best case.
Use Case: Suitable for small or unsorted datasets.

Binary Search:

Time Complexity: O(log n) in all cases (after sorting).
Use Case: Suitable for large, sorted datasets. Much faster than linear search for big data.*/