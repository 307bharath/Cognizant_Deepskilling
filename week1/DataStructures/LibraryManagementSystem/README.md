# Library Management System

This project demonstrates a simple library management system in Java, focusing on searching for books by title using linear and binary search algorithms.

---

## 1. Search Algorithms Overview

- **Linear Search:**  
  Checks each element in the list one by one until the target is found or the list ends.  
  - **Time Complexity:** O(n)
  - **When to use:** Small or unsorted datasets.

- **Binary Search:**  
  Repeatedly divides the sorted list in half to locate the target.  
  - **Time Complexity:** O(log n)
  - **When to use:** Large, sorted datasets.

---

## 2. Book Class

```java
package LibraryManagementSystem;

public class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    @Override
    public String toString() {
        return "BookID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}
```

---

## 3. Search Implementation

```java
package LibraryManagementSystem;

import java.util.Arrays;
import java.util.Comparator;

public class BookSearch {

    // Linear search by title
    public static Book linearSearch(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }

    // Binary search by title (array must be sorted by title)
    public static Book binarySearch(Book[] books, String targetTitle) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(targetTitle);
            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
```

---

## 4. Main Class to Test

```java
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
        System.out.println("Linear Search Result: " + (found != null ? found : "Not found"));

        // Sort books by title for binary search
        Arrays.sort(books, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));

        // Binary Search
        found = BookSearch.binarySearch(books, searchTitle);
        System.out.println("Binary Search Result: " + (found != null ? found : "Not found"));
    }
}
```

---

## 5. Analysis

- **Linear Search:** O(n) — checks each book one by one.  
  - Best for small or unsorted lists.
- **Binary Search:** O(log n) — much faster, but requires the list to be sorted by title.  
  - Best for large, sorted lists.

**When to use which?**
- Use **linear search** for small or unsorted data.
- Use **binary search** for large, sorted data for better performance.

---
