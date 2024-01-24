package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class    AccountController {

    @GetMapping("/myAccount")
    public String getAccount() {
        return "Hello from AccountController";
    }


}
