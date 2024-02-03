package com.example.demo.repository;

import com.example.demo.model.AccountTransactions;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccountTransactionsRepository extends MongoRepository<AccountTransactions, String> {
    List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(String customerId);
}
