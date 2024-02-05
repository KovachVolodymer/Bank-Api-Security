package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Notice;

@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {

    @Query(value = "{ 'noticeEndDt' : { $gte : ?0 } }")
    List<Notice> findAllActiveNotices();

}
