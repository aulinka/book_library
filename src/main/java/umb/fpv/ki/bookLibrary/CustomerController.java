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
        Customer customer = customerService.createCustomer(c.firstName,c.lastName,c.email);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.firstName = (customer.firstName);
        customerDTO.lastName = (customer.lastName);
        customerDTO.email = (customer.email);
        customerDTO.id = (customer.id);
        return customerDTO;
    }


    @GetMapping("/api/customers")
    public List<CustomerDTO> listCustomers(){
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        List<Customer> customers = customerService.listCustomers();
        for (Customer c: customers){
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.firstName = (c.firstName);
            customerDTO.lastName = (c.lastName);
            customerDTO.email = (c.email);
            customerDTO.id = (c.id);
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @GetMapping("/api/customers/{customerId}")
    public CustomerDTO getCustomerById(@PathVariable long customerId){
        CustomerDTO customerDTO = new CustomerDTO();
        Customer customer = customerService.getCustomerById(customerId);
        customerDTO.id = (customerId);
        customerDTO.email = (customer.email);
        customerDTO.firstName = (customer.firstName);
        customerDTO.lastName = (customer.lastName);
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