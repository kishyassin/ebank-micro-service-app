package org.example.ebankservice.web;

import org.example.ebankservice.entities.BankAccount;
import org.example.ebankservice.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankAccountRestController {
    @Autowired
    BankAccountService bankAccountService;

    @GetMapping("/bank-accounts")
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountService.getAllBankAccounts();
    }

    @GetMapping("/bank-accounts/customer/{customerId}")
    public List<BankAccount> getBankAccountsByCustomerId(@PathVariable Long customerId) {
        return bankAccountService.getBankAccountsByCustomerId(customerId);
    }

    @GetMapping("/bank-accounts/{id}")
    public BankAccount getBankAccount(@PathVariable Long id) {
        return bankAccountService.getBankAccountById(id);
    }

    @PostMapping("/bank-accounts")
    public BankAccount addBankAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountService.addBankAccount(bankAccount);
    }

}
