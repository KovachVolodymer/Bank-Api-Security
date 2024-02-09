package com.example.demo.controller;

import com.example.demo.model.AccountTransactions;
import com.example.demo.repository.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {
    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;

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
    @GetMapping("/accountBalance")
    public List<AccountTransactions> getAccountBalanceDetails(@RequestParam String id) {
        List<AccountTransactions> accountTransactions = accountTransactionsRepository.
                findByAccountIdOrderByTransactionDtDesc(id);
        if (accountTransactions != null ) {
            return accountTransactions;
        }else {
            return null;
        }
    }

    @PostMapping("/addBalance")
    public String addBalance(@RequestParam String id, @RequestParam String amount) {
        AccountTransactions accountTransactions = new AccountTransactions();
        accountTransactions.setAccountId(id);
        accountTransactions.setTransactionAmount(Double.parseDouble(amount));
        accountTransactions.setTransactionType("Credit");
        accountTransactionsRepository.save(accountTransactions);
        return "Amount added successfully";
    }

    @PostMapping("/withdrawBalance")
    public String withdrawBalance(@RequestParam String id, @RequestParam String amount) {
        AccountTransactions accountTransactions = new AccountTransactions();
        accountTransactions.setAccountId(id);
        accountTransactions.setTransactionAmount(Double.parseDouble(amount));
        accountTransactions.setTransactionType("Debit");
        accountTransactionsRepository.save(accountTransactions);
        return "Amount withdrawn successfully";
    }



}
