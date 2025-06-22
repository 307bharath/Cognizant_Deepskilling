package LibraryManagementSystem;


import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book("B1", "Java Programming", "James Gosling"),
            new Book("B2", "Data Structures", "Robert Lafore"),
            new Book("B3", "Algorithms", "Thomas Cormen"),
            new Book("B4", "Operating Systems", "Abraham Silberschatz")
        };

        // Linear Search
        String searchTitle = "Algorithms";
        Book found = BookSearch.linearSearch(books, searchTitle);
        System.out.println("\nLinear Search Result: " + (found != null ? found : "Not found"));

        // Sort books by title for binary search
        Arrays.sort(books, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));

        // Binary Search
        found = BookSearch.binarySearch(books, searchTitle);
        System.out.println("\nBinary Search Result: " + (found != null ? found : "Not found"));
    }
}
