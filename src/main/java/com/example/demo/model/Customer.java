package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "Users")
public class Customer {
    @Id
    private String id;

    private String password;
    private String email;
    private String role;


}
