package com.example.demo.repository;

import com.example.demo.model.Notice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoticeRepository extends MongoRepository<Notice, String>{
    List<Notice> findAllActiveNotices();
}
