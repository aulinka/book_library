package umb.fpv.ki.bookLibrary;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/api/customers")
    public CustomerDTO createCustomer(@RequestBody CustomerDTO c){
        Customer customer = customerService.createCustomer(c.getFirstName(),c.getLastName(),c.getEmail(),c.getId());
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(customer.firstName);
        customerDTO.setLastName(customer.lastName);
        customerDTO.setEmail(customer.email);
        customerDTO.setId(customer.id);
        return customerDTO;
    }


    @GetMapping("/api/customers")
    public List<CustomerDTO> listCustomers(){
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        List<Customer> customers = customerService.listCustomers();
        for (Customer c: customers){
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setFirstName(c.firstName);
            customerDTO.setLastName(c.lastName);
            customerDTO.setEmail(c.email);
            customerDTO.setId(c.id);
        }
        return customerDTOS;
    }

    @GetMapping("/api/customers/{customerId}")
    public CustomerDTO getCustomerById(@PathVariable long customerId){
        CustomerDTO customerDTO = new CustomerDTO();
        Customer customer = customerService.getCustomerById(customerId);
        customerDTO.setId(customerId);
        return customerDTO;
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