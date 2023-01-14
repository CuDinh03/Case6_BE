package com.example.casestudy6.repository;

import com.example.casestudy6.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICommentRepo extends JpaRepository<Comment, Long> {

    @Query(value = "select * from  where (status = 1 or status = 2) order by post_day desc ", nativeQuery = true)
    List<Comment> findAll();

    @Query(value = "insert into status_comment value (:status_id, :comment_id)", nativeQuery = true)
    void saveComment(@Param("status_id") Long status_id, @Param("comment_id") Long comment_id);

}
