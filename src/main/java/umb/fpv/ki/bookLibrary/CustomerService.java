package umb.fpv.ki.bookLibrary;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    public final List<Customer> customers = new ArrayList();
    private CustomerService customerService;
    private CustomerRepository customerRepository;



    public CustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer createCustomer(String firstName, String lastName, String email, long id){
        Customer customer = new Customer();
        customer.firstName = firstName;
        customer.lastName = lastName;
        customer.email = email;
        customer.id = id;
        return customer;
    }
    public List<Customer> listCustomers(){
        return customers;
    }

    public Customer getCustomerById(long customerId){
        Customer c = new Customer();
        Customer customer = customerService.getCustomerById(c.id);
        return c;
    }
    public  Customer updateCustomerById(long customerId, Customer customer){
        for(Customer c: customers){
            if (c.id == customerId){
                c = customer;
            }
        }
        return customer;
    }
    public void deleteCustomerById(long customerId){
        customers.removeIf(customer -> customer.id == customerId);
    }
}