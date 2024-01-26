package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    CustomerRepository customerRepository;

    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody Customer customer)
    {
        ResponseEntity response=null;
        Customer savedCustomer=null;
        try {
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
            savedCustomer=customerRepository.save(customer);
            response = ResponseEntity.status(HttpStatus.CREATED)
                    .body("Given user details are successfully registration");
        }catch (Exception exception)
        {
            response=ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception "+exception.getMessage());
        }
        return response;

    }

}
