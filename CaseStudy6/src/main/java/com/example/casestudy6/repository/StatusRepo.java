package com.example.casestudy6.repository;

import com.example.casestudy6.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatusRepo extends JpaRepository<Status, Long> {

    @Query(value = "select * from status where status = 1 order by post_day desc ", nativeQuery = true)
    Iterable<Status> findAllPublicStatus();

    @Query(value = "select * from status inner join friends on (friends.account1 = :userId and status.status = 2 and friends.status = 2) order by status.post_day desc",nativeQuery = true)
    Iterable<Status> findAllFriendStatus(@Param("userId") Long userId);

    @Query(value = "select * from status where account_id = :id and (status <> 4)  order by post_day desc", nativeQuery = true)
    Iterable<Status> findByAccountId(@Param("id") Long id);

    @Query(value = "select * from status order by id desc limit 1", nativeQuery = true)
    Status findLastStatus();

    @Query(value = "select * from status where id = :id", nativeQuery = true)
    Optional<Status> findById(@Param("id") Long id);

    @Query(value = "select * from status where status.account_id = :id and content like ('%' + any +'%') order by post_day desc", nativeQuery = true)
    List<Status> findByContent (@Param("any")  String any, @Param("id") Long id);

}
