package org.example.ebankservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.ebankservice.entities.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "fallbackGetCustomerById")
    Customer getCustomerById(@PathVariable Long id);

    default Customer fallbackGetCustomerById(Long id, Throwable throwable) {
        throw new RuntimeException("Customer" + id +" not found");
    }
}
