# Task Management System

This project demonstrates a simple task management system using a singly linked list in Java, including adding, searching, traversing, and deleting tasks.

---

## 1. Understanding Linked Lists

**Singly Linked List:**  
Each node points to the next node. Traversal is one-way (forward only).

**Doubly Linked List:**  
Each node points to both the next and previous nodes. Traversal is possible in both directions.

---

## 2. Task Class

```java
package TaskManagementSystem;

public class Task {
    private String taskId;
    private String taskName;
    private String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getTaskId() { return taskId; }
    public String getTaskName() { return taskName; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "TaskID: " + taskId + ", Name: " + taskName + ", Status: " + status;
    }
}
```

---

## 3. Singly Linked List Implementation

```java
package TaskManagementSystem;

public class TaskLinkedList {
    private static class Node {
        Task task;
        Node next;
        Node(Task task) { this.task = task; }
    }

    private Node head;

    // Add task at the end
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = newNode;
    }

    // Search task by ID
    public Task searchTask(String taskId) {
        Node curr = head;
        while (curr != null) {
            if (curr.task.getTaskId().equals(taskId)) return curr.task;
            curr = curr.next;
        }
        return null;
    }

    // Traverse (display all)
    public void displayAll() {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.task);
            curr = curr.next;
        }
    }

    // Delete task by ID
    public boolean deleteTask(String taskId) {
        if (head == null) return false;
        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return true;
        }
        Node curr = head;
        while (curr.next != null) {
            if (curr.next.task.getTaskId().equals(taskId)) {
                curr.next = curr.next.next;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}
```

---

## 4. Main Class to Test

```java
package TaskManagementSystem;

public class Main {
    public static void main(String[] args) {
        TaskLinkedList tasks = new TaskLinkedList();

        tasks.addTask(new Task("T1", "Design UI", "Pending"));
        tasks.addTask(new Task("T2", "Implement Backend", "In Progress"));
        tasks.addTask(new Task("T3", "Testing", "Pending"));

        System.out.println("All Tasks:");
        tasks.displayAll();

        System.out.println("\nSearching for T2:");
        Task found = tasks.searchTask("T2");
        System.out.println(found != null ? found : "Not found");

        System.out.println("\nDeleting T2:");
        tasks.deleteTask("T2");
        tasks.displayAll();
    }
}
```

---

## 5. Time Complexity Analysis

- **Add:** O(n) (to add at end)
- **Search:** O(n)
- **Traverse:** O(n)
- **Delete:** O(n)

---

## 6. Advantages of Linked Lists over Arrays

- **Dynamic size:** Can grow or shrink as needed.
- **Efficient insert/delete:** No need to shift elements (except for searching the node).
- **No wasted space:** No need to predefine capacity.

**When to use linked lists:**  
- When frequent insertions/deletions are required.
- When the number of elements is unknown or changes frequently.

---

