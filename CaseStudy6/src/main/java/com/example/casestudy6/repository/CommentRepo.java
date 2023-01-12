package com.example.casestudy6.repository;

import com.example.casestudy6.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CommentRepo extends PagingAndSortingRepository {
    @Query(value = "select * from comment order by id desc ", nativeQuery = true)
    List<Comment> findAll();

    @Query(value = "select count(*) from comment", nativeQuery = true)
    Integer numberOfComment();

//    @Query(value = "select * from comment where account_id = :id and (comment <> 4)  order by post_day desc", nativeQuery = true)
//    Iterable<Comment> findByAccountId(@Param("id") Long id);

//    @Query(value = "select * from comment order by id desc limit 1", nativeQuery = true)
//    Comment findLastComment();

//    @Query(value = "select * from comment where id = :id", nativeQuery = true)
//    Optional<Comment> findById(@Param("id") Long id);
}

