package umb.fpv.ki.bookLibrary;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {


    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer){
        return createCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getCustomerByLastName(@RequestParam String lastName){
        return getCustomerByLastName(lastName);
    }
    @GetMapping("/customers/{customerId}")
    public Customer getCustomerById(@PathVariable long customerId){
        return getCustomerById(customerId);
    }
    @PutMapping("/customers/{customerId}")
    public  Customer updateCustomerById(@PathVariable long customerId,@RequestBody Customer customer){
        return updateCustomerById(customerId,customer);
    }
    @DeleteMapping("/customers/{customerId}")
    public void deleteCustomerById(@PathVariable long customerId){
        deleteCustomerById(customerId);
    }
}