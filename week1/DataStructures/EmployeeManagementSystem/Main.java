package EmployeeManagementSystem;


public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);
        // Adding employees
        System.out.println("Adding Employees:");
        manager.addEmployee(new Employee("E1", "Bharadwaj", "Manager", 80000));
        manager.addEmployee(new Employee("E2", "Geetanjali", "Developer", 60000));
        manager.addEmployee(new Employee("E3", "Ganesh", "Tester", 50000));

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