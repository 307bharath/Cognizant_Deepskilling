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

        System.out.println("\nAdding a new task:");
        tasks.addTask(new Task("T4", "Deployment", "Pending"));
        tasks.displayAll();
    }
}