package org.example.ebankservice.services;

import org.example.ebankservice.entities.BankAccount;
import org.example.ebankservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public List<BankAccount> getBankAccountsByCustomerId(Long customerId) {
        return bankAccountRepository.findByCustomerId(customerId);
    }

    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    public BankAccount getBankAccountById(Long id) {
        return bankAccountRepository.findById(id).orElse(null);
    }

    public BankAccount addBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }
}
