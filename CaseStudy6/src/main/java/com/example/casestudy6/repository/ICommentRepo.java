package com.example.casestudy6.repository;

import com.example.casestudy6.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICommentRepo extends JpaRepository<Comment, Long> {

    @Modifying
    @Transactional
    @Query(value = "insert into status_comment value (:status_id, :comment_id)", nativeQuery = true)
    void saveComment(@Param("status_id") Long status_id, @Param("comment_id") Long comment_id);

    @Query(nativeQuery = true, value = "SELECT * FROM comment WHERE commnent_id= :comment_id")
    Comment findCommentById(@Param("comment_id") Long id);

    @Query(value = "select * from comment order by id ", nativeQuery = true)
    Comment findLastComments();

    @Query(nativeQuery = true, value = "select a.text, b.last_name, b.first_name,  a.post_day, b.img_id from (comment a inner join account b on a.account_id = b.id ) inner join status on b.id = status.account_id where status.id = :status_id order by  a.post_day desc")
    Iterable<Comment> findAllByStatusId(@Param("status_id") Long id);
}
