package com.example.casestudy6.repository;

import com.example.casestudy6.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepo extends JpaRepository<Status, Long> {
    @Query(value = "select * from status where account_id = :id and status <> 0 order by post_day desc", nativeQuery = true)
    Optional<Status> findById(@Param("id") Long id);
}
