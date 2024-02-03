package com.example.demo.repository;

import com.example.demo.model.Loans;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoanRepository extends MongoRepository<Loans, String> {
}
