package com.example.casestudy6.repository;

import com.example.casestudy6.model.Comment;
import com.example.casestudy6.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICommentRepo extends JpaRepository<Comment, Long> {

    @Query(value = "select * from  where (status = 1 or status = 2) order by post_day desc ", nativeQuery = true)
    List<Comment> findAll();

}
