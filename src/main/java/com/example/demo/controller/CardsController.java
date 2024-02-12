package com.example.demo.controller;

import com.example.demo.model.Cards;
import com.example.demo.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    // Add a new endpoint to get the card details for a specific account

    @PostMapping("/addCard")
    public String addCard(@RequestParam String id, @RequestParam String cardNumber, @RequestParam String cardType) {
        Cards card = new Cards();
        card.setCustomerId(id);
        card.setCardNumber(cardNumber);
        card.setCardType(cardType);
        cardsRepository.save(card);
        return "Card added successfully";
    }

    @PostMapping("/deleteCard")
    public String deleteCard(@RequestParam String id, @RequestParam String cardNumber) {
        cardsRepository.deleteByCustomerIdAndCardNumber(id, cardNumber);
        return "Card deleted successfully";
    }

    @PostMapping("/updateCard")
    public String updateCard(@RequestParam String id, @RequestParam String cardNumber, @RequestParam String cardType) {
        Cards card = cardsRepository.findByCustomerIdAndCardNumber(id, cardNumber);
        if (card != null) {
            card.setCardType(cardType);
            cardsRepository.save(card);
            return "Card updated successfully";
        } else {
            return "Card not found";
        }
    }

    @PostMapping("/blockCard")
    public String blockCard(@RequestParam String id, @RequestParam String cardNumber) {
        Cards card = cardsRepository.findByCustomerIdAndCardNumber(id, cardNumber);
        if (card != null) {
            card.setCardStatus("Blocked");
            cardsRepository.save(card);
            return "Card blocked successfully";
        } else {
            return "Card not found";
        }
    }

    @PostMapping("/unblockCard")
    public String unblockCard(@RequestParam String id, @RequestParam String cardNumber) {
        Cards card = cardsRepository.findByCustomerIdAndCardNumber(id, cardNumber);
        if (card != null) {
            card.setCardStatus("Active");
            cardsRepository.save(card);
            return "Card unblocked successfully";
        } else {
            return "Card not found";
        }
    }

    @PostMapping("/replaceCard")
    public String replaceCard(@RequestParam String id, @RequestParam String cardNumber, @RequestParam String newCardNumber) {
        Cards card = cardsRepository.findByCustomerIdAndCardNumber(id, cardNumber);
        if (card != null) {
            card.setCardNumber(newCardNumber);
            cardsRepository.save(card);
            return "Card replaced successfully";
        } else {
            return "Card not found";
        }
    }





}
