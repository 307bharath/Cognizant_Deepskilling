package DependencyInjectionExample;

public class Main {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        Customer customer = service.getCustomer("1");
        if (customer != null) {
            System.out.println("Customer found: " + customer.getName());
        } else {
            System.out.println("Customer not found.");
        }
        System.out.println("Displaying all customers:");
        service.displayAllCustomers();

        Customer newCustomer = new Customer("3", "Kanna");
        service.saveCustomer(newCustomer);
        System.out.println("New customer saved: " + newCustomer.getName());
        service.displayAllCustomers();

        Customer updatedCustomer = new Customer("3", "Ganesh");
        service.updateCustomer(updatedCustomer);
        System.out.println("Customer updated: " + updatedCustomer.getName());
        service.displayAllCustomers();

        Customer deletedCustomer = service.deleteCustomer("3"); 
        if (deletedCustomer != null) {
            System.out.println("Customer deleted: " + deletedCustomer.getName());
        } else {
            System.out.println("Customer not found for deletion.");
        }
        
        System.out.println("Final list of customers:");
        service.displayAllCustomers();
    }
        
}