package com.example.demo.repository;

import com.example.demo.model.Accounts;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountsRepository extends MongoRepository<Accounts, String> {
}
