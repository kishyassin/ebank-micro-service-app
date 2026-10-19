package org.example.ebankservice.repositories;

import org.example.ebankservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    List<BankAccount> findByCustomerId(Long customerId);
}
