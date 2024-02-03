package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "customer")
public class Accounts {
    @Id
    private String customerId;


    private String accountNumber;
    private String accountType;
    private String branchType;
    private String createdDate;

}
