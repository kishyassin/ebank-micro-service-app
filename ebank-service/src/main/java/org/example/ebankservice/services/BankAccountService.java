package org.example.ebankservice.services;

import org.example.ebankservice.entities.BankAccount;
import org.example.ebankservice.entities.model.Customer;
import org.example.ebankservice.feign.CustomerRestClient;
import org.example.ebankservice.repositories.BankAccountRepository;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;
    private final CustomerRestClient customerRestClient;

    public BankAccountService(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    public List<BankAccount> getBankAccountsByCustomerId(Long customerId) {
        return bankAccountRepository.findByCustomerId(customerId);
    }

    @McpTool(description = "Get all bank accounts")
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    @McpTool(description = "Get bank account by ID")
    public BankAccount getBankAccountById(@McpToolParam(description = "ID of the bank account") Long id) {
        BankAccount bankAccount = bankAccountRepository.findById(id).orElse(null);
        if (bankAccount != null && bankAccount.getCustomerId() != null) {
            bankAccount.setCustomer(customerRestClient.getCustomerById(bankAccount.getCustomerId()));
        }
        return bankAccount;
    }

    @McpTool(description = "add new bank account")
    public BankAccount addBankAccount(@McpToolParam(description = "Bank account to add (balance, type, customer)") BankAccount bankAccount) {
        Customer customer = customerRestClient.getCustomerById(bankAccount.getCustomerId());
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }
        return bankAccountRepository.save(bankAccount);
    }
}
