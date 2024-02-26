package com.example.demo.controller;

import com.example.demo.model.Authority;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/all")
    public ResponseEntity<Iterable<Customer>> getAllUsers()
    {
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @GetMapping("/idGet/{id}")
    public ResponseEntity<String> getUser(@PathVariable String id)
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

    @PatchMapping("/id")
    public ResponseEntity<String> updatePartialUser(@RequestParam String id, @RequestBody Customer customer)
    {
        Optional<Customer> customer1 = customerRepository.findById(id);
        if(customer.getEmail()!=null)
        {
            customer1.get().setEmail(customer.getEmail());
        }
        if(customer.getPassword()!=null)
        {
            customer1.get().setPassword(customer.getPassword());
        }
        customerRepository.save(customer1.get());
        return ResponseEntity.ok(customer1.get().toString());
    }

    @DeleteMapping("/idDelete")
    public ResponseEntity<String> deleteUser(@RequestParam String id)
    {
        Optional<Customer> customer = customerRepository.findById(id);
        customerRepository.delete(customer.get());
        return ResponseEntity.ok("Deleted");
    }

    @PatchMapping("/addRole/{id}")
    public ResponseEntity<String> updatePassword(@PathVariable String id, @RequestBody Authority authority) {
        Optional<Customer> customer = customerRepository.findById(id);
        Set<Authority> authorities = customer.get().getAuthorities();
        authorities.add(authority);
        customer.get().setAuthorities(authorities);
        customerRepository.save(customer.get());
        return ResponseEntity.ok(customer.get().toString());
    }



}
