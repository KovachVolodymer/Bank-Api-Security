package com.example.demo.repository;

import com.example.demo.model.Loans;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LoanRepository extends MongoRepository<Loans, String> {
    List<Loans> findByCustomerIdOrderByStartDtDesc(String id);
}
