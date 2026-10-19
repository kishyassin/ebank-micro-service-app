package org.example.customerservice;

import org.example.customerservice.entities.Customer;
import org.example.customerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerService customerService){
        return args -> {
            customerService.addCustomer(new Customer(null, "John", "john@gmail.com"));
            customerService.addCustomer(new Customer(null, "Ali", "Ali@gmail.com"));
            customerService.addCustomer(new Customer(null, "Yassine", "Ysn@gmail.com"));
            customerService.addCustomer(new Customer(null, "Imane", "imn@gmail.com"));

        };
    }
}
