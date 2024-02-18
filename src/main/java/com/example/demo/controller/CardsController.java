package com.example.demo.controller;

import com.example.demo.model.Cards;
import com.example.demo.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class CardsController {
    @Autowired
    private CardsRepository cardsRepository;

    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam String id) {
        List<Cards> cards = cardsRepository.findByCustomerId(id);
        if (cards != null ) {
            return cards;
        }else {
            return null;
        }
    }

    @GetMapping("/all")
    public List<Object> findAll(){
        List<Cards> cards= cardsRepository.findAll();
        return Collections.singletonList(cards);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addCard(@RequestBody Cards card){
        cardsRepository.save(card);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteCard(@RequestParam String id){
        cardsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateCard(@RequestBody Cards card){
        cardsRepository.save(card);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/patch")
    public ResponseEntity<Object> patchCard(@RequestBody Cards card){
        cardsRepository.save(card);
        return ResponseEntity.ok().build();
    }





}
