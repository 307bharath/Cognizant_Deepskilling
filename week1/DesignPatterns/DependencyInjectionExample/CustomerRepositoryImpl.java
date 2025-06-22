package DependencyInjectionExample;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> customerData = new HashMap<>();

    public CustomerRepositoryImpl() {
        // Sample data
        customerData.put("1", new Customer("1", "Bharadwaj"));
        customerData.put("2", new Customer("2", "Geetanjali"));
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerData.get(id);
    }
    @Override
    public Customer saveCustomer(Customer customer) {
        customerData.put(customer.getId(), customer);
        return customer;
    }
    @Override
    public Customer deleteCustomer(String id) {
        return customerData.remove(id);
    }
    @Override
    public Customer updateCustomer(Customer customer) {
        customerData.put(customer.getId(), customer); // Adds or updates
        return customer;
    }

    @Override
    public void displayAllCustomers() {
        for (Customer customer : customerData.values()) {
            System.out.println("Customer ID: " + customer.getId() + ", Name: " + customer.getName());
        }
    }

}