package com.example.demo.controller;

import com.example.demo.model.AccountTransactions;
import com.example.demo.repository.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {
    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;


    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam String id) {
        List<AccountTransactions> accountTransactions = accountTransactionsRepository.
                findByCustomerIdOrderByTransactionDtDesc(id);
        if (accountTransactions != null ) {
            return accountTransactions;
        }else {
            return null;
        }
    }

    // Add a new endpoint to get the balance details for a specific account

}
