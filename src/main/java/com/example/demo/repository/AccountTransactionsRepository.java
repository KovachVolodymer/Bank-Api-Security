package com.example.demo.repository;

import com.example.demo.model.AccountTransactions;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountTransactionsRepository extends MongoRepository<AccountTransactions, String> {
}
