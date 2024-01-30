package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;
    @GetMapping("/id")
    public ResponseEntity<String> getUser(@RequestParam String id)
    {
        Optional<Customer> customer = customerRepository.findById(id);
        return ResponseEntity.ok(customer.get().toString());
    }

    @PutMapping("/id")
    public ResponseEntity<String> updateUser(@RequestParam String id, @RequestBody Customer customer)
    {
        Optional<Customer> customer1 = customerRepository.findById(id);
        customer1.get().setEmail(customer.getEmail());
        customer1.get().setPassword(customer.getPassword());
        customerRepository.save(customer1.get());
        return ResponseEntity.ok(customer1.get().toString());
    }

    @DeleteMapping("/id")
    public ResponseEntity<String> deleteUser(@RequestParam String id)
    {
        Optional<Customer> customer = customerRepository.findById(id);
        customerRepository.delete(customer.get());
        return ResponseEntity.ok("Deleted");
    }

}
