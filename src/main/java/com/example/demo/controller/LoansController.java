package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @GetMapping("/myLoans")
    public String getLoans() {
        return "Hello from LoansController";
    }

}
