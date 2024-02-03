package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Getter
@Setter
@Document(collection = "account-transactions")
public class AccountTransactions {

    @Id
    private String transactionId;

    private long accountNumber;
    private int customerId;
    private Date transactionDt;
    private String transactionSummary;
    private String transactionType;
    private int transactionAmt;
    private int closingBalance;
    private String createDt;
}
