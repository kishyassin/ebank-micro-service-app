package org.example.customerservice;

import org.example.customerservice.entities.Customer;
import org.example.customerservice.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CustomerServiceApplicationTests {

    @Autowired
    private CustomerService customerService;

    @Test
    void contextLoads() {
    }

    @Test
    void testAddCustomerWithPredefinedId() {
        Customer input = new Customer(5L, "Test Client", "test@client.com");
        Customer saved = customerService.addCustomer(input);
        assertNotNull(saved);
        assertNotNull(saved.getId());
        assertEquals("Test Client", saved.getName());
        assertEquals("test@client.com", saved.getEmail());
    }

}
