package umb.fpv.ki.bookLibrary;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    public static final List<Customer> customers = new ArrayList();

    public Customer createCustomer(Customer customer){
        customers.add(customer);
        return customer;
    }
    public List<Customer> getCustomerByLastName(String lastname){
        return customers.stream().filter(customer -> customer.lastName.contains(lastname)).collect(Collectors.toList());
    }
    public Customer getCustomerById(long customerId){
        return customers.stream().filter(customer -> customer.id == customerId).findFirst().get();
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