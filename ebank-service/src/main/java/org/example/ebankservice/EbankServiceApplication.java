package org.example.ebankservice;

import org.example.ebankservice.entities.BankAccount;
import org.example.ebankservice.services.BankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountService bankAccountService){
        return args -> {
            for (int i = 1 ; i < 5 ; i++){
                BankAccount bankAccount = BankAccount.builder()
                        .createdAt(new Date())
                        .balance((float) (Math.random() * 100))
                        .type(Math.random() > 0.5 ? "CURRENT-ACCOUNT" : "SAVING-ACCOUNT")
                        .customerId((long) i)
                        .build();
                bankAccountService.addBankAccount(bankAccount);
            }
        };
    }
}
