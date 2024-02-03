package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
@Getter
@Setter
@Document(collection = "notice_details")
public class Notice {

    @Id
    private int noticeId;

    private String noticeSummary;
    private String noticeDetails;

    private Date noticeBegDt;
    private Date noticeEndDt;
    private Date createDt;
    private Date updateDt;
}
