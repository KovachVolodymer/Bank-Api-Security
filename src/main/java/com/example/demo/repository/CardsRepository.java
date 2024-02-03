package com.example.demo.repository;

import com.example.demo.model.Cards;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CardsRepository extends MongoRepository<Cards, String> {
    List<Cards> findByCustomerId(String id);
}
