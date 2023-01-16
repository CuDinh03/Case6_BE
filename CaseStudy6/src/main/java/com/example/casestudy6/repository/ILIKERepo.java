package com.example.casestudy6.repository;

import com.example.casestudy6.model.Comment;
import com.example.casestudy6.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.Like;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ILIKERepo extends JpaRepository<Likes, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into status_likes value (:status_id, :likes_id)", nativeQuery = true)
    void saveLikesStatus(@Param("status_id") Long status_id, @Param("likes_id") Long likes_id);

    @Query(nativeQuery = true, value = "select a.id from (likes a inner join account b on a.account_id = b.id ) inner join status on b.id = status.account_id where status.id = :status_id order by  a.post_day desc")
    Iterable<Likes> findAllByStatusId(@Param("status_id") Long id);

    @Query(nativeQuery = true, value = "select * from Likes order by id desc limit 1")
    Likes findLastLikes();


}
