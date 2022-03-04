package umb.fpv.ki.bookLibrary;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    CustomerService customerService;

    @PostMapping("/api/customers")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }
    @GetMapping("/api/customers")
    public List<Customer> getCustomerByLastName(@RequestParam String lastName){
        return customerService.getCustomerByLastName(lastName);
    }
    @GetMapping("/api/customers/{customerId}")
    public Customer getCustomerById(@PathVariable long customerId){
        return customerService.getCustomerById(customerId);
    }
    @PutMapping("/api/customers/{customerId}")
    public  Customer updateCustomerById(@PathVariable long customerId,@RequestBody Customer customer){
        return customerService.updateCustomerById(customerId,customer);
    }
    @DeleteMapping("/api/customers/{customerId}")
    public void deleteCustomerById(@PathVariable long customerId){
        customerService.deleteCustomerById(customerId);
    }
}