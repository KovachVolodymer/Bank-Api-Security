package com.example.demo.repository;

import com.example.demo.model.Notice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoticeRepository extends MongoRepository<Notice, String>{
}
