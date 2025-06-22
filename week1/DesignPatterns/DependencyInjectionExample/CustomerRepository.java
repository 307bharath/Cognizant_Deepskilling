package DependencyInjectionExample;

public interface CustomerRepository {
    Customer findCustomerById(String id);
    // Other methods can be added as needed
    Customer saveCustomer(Customer customer);
    Customer deleteCustomer(String id);
    Customer updateCustomer(Customer customer);
    void displayAllCustomers(); // Optional method to display all customers
}
