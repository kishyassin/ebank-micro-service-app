package org.example.customerservice.services;

import org.example.customerservice.entities.Customer;
import org.example.customerservice.repositories.CustomerRepository;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @McpTool(description = "Get all customers")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @McpTool(description = "Get customer by id")
    public Customer getCustomerById(@McpToolParam(description = "Customer id") Long id){
        return customerRepository.findById(id).orElse(null);
    }

    @McpTool(description = "Add customer")
    public Customer addCustomer(@McpToolParam(description = "Customer") Customer customer){
        customer.setId(null);
        return customerRepository.save(customer);
    }

}
