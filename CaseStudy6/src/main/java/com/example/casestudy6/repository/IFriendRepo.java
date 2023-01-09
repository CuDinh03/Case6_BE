package com.example.casestudy6.repository;

import com.example.casestudy6.model.Friends;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface IFriendRepo extends PagingAndSortingRepository<Friends,Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM Friends where Friends.account1 = :account1 and Friends.status  = 2")
    ArrayList<Friends> getAllFriends(@Param("account1") String account1);
    @Transactional

    @Modifying
    @Query(nativeQuery  = true,value = "UPDATE Friends SET status = 3 WHERE Friends.account1 = :account1 and Friends.account2_id = :account2_id")
    void blockFriend(@Param("account1") long account1, @Param("account2_id") long account2_id);
    @Query(nativeQuery = true,value = "SELECT * FROM friends WHERE account1 = :account1 and account2_id = :account2_id")
    Friends findMeInList(@Param("account1") long account1,@Param("account2_id") long account2_id);
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM friends WHERE account1= :account2_id and account2_id= :account1")
    void deleteRelationship(@Param("account2_id") long account2_id,@Param("account1") long account1);



    @Query(nativeQuery=true,value = "SELECT * FROM friends WHERE account1= :account1 AND status=2")
    List<Friends> getAllFriendsOfAccount1(@Param("account1") long account1);

    @Query(nativeQuery=true,value = "SELECT * FROM friends WHERE account1= :account2_id AND status=2")
    List<Friends> getAllFriendsOfAccount2(@Param("account2_id") long account2_id);

@Transactional
@Modifying
    @Query(nativeQuery=true,value = "INSERT INTO friends (account1, status,account2_id) VALUES (:id1, 1, :id2)")
    void sendRequest(@Param("id1") long id1, @Param("id2") long id2);
    @Transactional
    @Modifying
    @Query(nativeQuery=true,value = "UPDATE friends SET status = 2 WHERE account1= :account1 AND account2_id =:account2_id")
    void updateStatus(@Param("account1") long account1, @Param("account2_id" ) long account2_id);
}
