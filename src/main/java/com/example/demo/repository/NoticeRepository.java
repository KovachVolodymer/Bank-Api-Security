package com.example.demo.repository;

<<<<<<< HEAD
import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Notice;

@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {

    @Query(value = "{ 'noticeEndDt' : { $gte : ?0 } }")
    List<Notice> findAllActiveNotices();

=======
import com.example.demo.model.Notice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoticeRepository extends MongoRepository<Notice, String>{
    List<Notice> findAllActiveNotices();
>>>>>>> c5af303323aff78faaab538d5168eb89b698b171
}
