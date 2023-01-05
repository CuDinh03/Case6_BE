package com.example.casestudy6.repository;

import com.example.casestudy6.model.Friends;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface IFriendRepo extends PagingAndSortingRepository<Friends,Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM Friends where Friends.account1 = :account1 and Friends.status  = 2")
    ArrayList<Friends> getAllFriends(@Param("account1") String account1);
}
