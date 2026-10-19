package org.example.customerservice.web;

import org.example.customerservice.entities.Customer;
import org.example.customerservice.repositories.CustomerRepository;
import org.example.customerservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestController {
    @Autowired
    public CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @PostMapping("/customers")
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }
}
