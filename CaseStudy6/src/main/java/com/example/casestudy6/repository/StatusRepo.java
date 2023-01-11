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

    @Query(value = "select * from status where (status = 1 or status = 2) order by post_day desc ", nativeQuery = true)
    List<Status> findAll();

    @Query(value = "select * from status where account_id = :id and (status <> 4)  order by post_day desc", nativeQuery = true)
    Iterable<Status> findByAccountId(@Param("id") Long id);

    @Query(value = "select * from status order by id desc limit 1", nativeQuery = true)
    Status findLastStatus();

    @Query(value = "select * from status where id = :id", nativeQuery = true)
    Optional<Status> findById(@Param("id") Long id);
}
