package umb.fpv.ki.bookLibrary;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    public final List<Customer> customers = new ArrayList();

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(String firstName, String lastName, String email){
        Customer customer = new Customer();
        customer.firstName = firstName;
        customer.lastName = lastName;
        customer.email = email;
        return customerRepository.save(customer);
    }
    public List<Customer> listCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(long customerId){
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        return optionalCustomer.orElse(null);
    }
    public  Customer updateCustomerById(long customerId, Customer customer){

        Customer c = this.getCustomerById(customerId);
        if(c != null){
            c.firstName = customer.firstName;
            c.lastName = customer.lastName;
            c.email = customer.email;
            return customerRepository.save(c);
        }
        return null;
    }
    public void deleteCustomerById(long customerId){
        customerRepository.deleteById(customerId);

    }
}