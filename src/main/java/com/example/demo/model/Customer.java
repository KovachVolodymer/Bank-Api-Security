package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "customer")
public class Customer {
    @Id
    private String id;

    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String email;
    private String role;
    private String mobileNumber;
    private String createDt;

    private Set<Authority> authorities=new HashSet<>();

    public Customer() {
    }


}
