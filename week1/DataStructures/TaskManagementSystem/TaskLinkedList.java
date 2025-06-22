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