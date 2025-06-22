package DependencyInjectionExample;


public class CustomerService {
    private CustomerRepository customerRepository;

    // Constructor injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(String id) {
        return customerRepository.findCustomerById(id);
    }
    public Customer saveCustomer(Customer customer) {
        return customerRepository.saveCustomer(customer);
    }
    public Customer deleteCustomer(String id) {
        return customerRepository.deleteCustomer(id);
    }
    public Customer updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }
    public void displayAllCustomers() {
        customerRepository.displayAllCustomers();
    }
}