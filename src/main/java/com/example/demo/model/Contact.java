package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;


@Getter
@Setter
@Document(collection = "contact_messages")
public class Contact {
    @Id
    private String contactId;


    private String contactName;


    private String contactEmail;

    private String subject;

    private String message;


    private Date createDt;

}
