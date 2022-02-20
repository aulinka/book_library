package umb.fpv.ki.bookLibrary;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {
    public static final List<Customer> customers = new ArrayList();

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer){
        customers.add(customer);
        return customer;
    }
    @GetMapping("/customers")
    public List<Customer> getCustomerByLastName(@RequestParam String lastName){
        return customers.stream().filter(customer -> customer.lastName.contains(lastName)).collect(Collectors.toList());
    }
    @GetMapping("/customers/{customerId}")
    public Customer getCustomerById(@PathVariable long customerId){
        return customers.stream().filter(customer -> customer.id == customerId).findFirst().get();
    }
    @PutMapping("/customers/{customerId}")
    public  Customer updateCustomerById(@PathVariable long customerId,@RequestBody Customer customer){
        for(Customer c: customers){
            if (c.id == customerId){
                c = customer;
            }
        }
        return customer;
    }
    @DeleteMapping("/customers/{customerId}")
    public void deleteCustomerById(@PathVariable long customerId){
        customers.removeIf(customer -> customer.id == customerId);
    }
}
