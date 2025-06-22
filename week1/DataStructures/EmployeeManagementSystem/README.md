# Employee Management System

This project demonstrates an employee management system using arrays in Java, including adding, searching, traversing, and deleting employee records.

---

## 1. Array Representation in Memory

Arrays are **contiguous blocks of memory** where each element is of the same type and can be accessed directly using an index.

**Advantages:**
- Fast random access (O(1) time for access by index)
- Simple and efficient for fixed-size collections

---

## 2. Employee Class

```java
package EmployeeManagementSystem;

public class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}
```

---

## 3. Employee Management with Array

```java
package EmployeeManagementSystem;

public class EmployeeManager {
    private Employee[] employees;
    private int size;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add employee
    public boolean addEmployee(Employee emp) {
        if (size < employees.length) {
            employees[size++] = emp;
            return true;
        }
        return false; // Array full
    }

    // Search employee by ID
    public Employee searchEmployee(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(id)) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse (display all)
    public void displayAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete employee by ID
    public boolean deleteEmployee(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(id)) {
                // Shift left
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                return true;
            }
        }
        return false;
    }
}
```

---

## 4. Main Class to Test

```java
package EmployeeManagementSystem;

public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee("E1", "Alice", "Manager", 80000));
        manager.addEmployee(new Employee("E2", "Bob", "Developer", 60000));
        manager.addEmployee(new Employee("E3", "Charlie", "Tester", 50000));

        System.out.println("All Employees:");
        manager.displayAll();

        System.out.println("\nSearching for E2:");
        Employee found = manager.searchEmployee("E2");
        System.out.println(found != null ? found : "Not found");

        System.out.println("\nDeleting E2:");
        manager.deleteEmployee("E2");
        manager.displayAll();
    }
}
```

---

## 5. Time Complexity Analysis

- **Add:** O(1) (if not full)
- **Search:** O(n)
- **Traverse:** O(n)
- **Delete:** O(n) (due to shifting elements)

---

## 6. Limitations of Arrays

- **Fixed size:** Cannot grow beyond initial capacity.
- **Inefficient deletes:** Deleting requires shifting elements.
- **Use arrays when:**  
  - The number of elements is known and fixed.
  - Fast random access is needed.
  - Memory usage must be minimal.

For dynamic collections, prefer `ArrayList` or other dynamic data structures.

---
