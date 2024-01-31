package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/contact")
    public String getContact() {
        return "Hello from ContactController";
    }

    @GetMapping("/contact2")
    public String getContact2() {
        return "Hello from ContactController2";
    }


}
