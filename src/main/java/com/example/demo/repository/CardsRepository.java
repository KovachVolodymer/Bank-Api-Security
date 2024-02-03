package com.example.demo.repository;

import com.example.demo.model.Cards;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardsRepository extends MongoRepository<Cards, String> {
}
