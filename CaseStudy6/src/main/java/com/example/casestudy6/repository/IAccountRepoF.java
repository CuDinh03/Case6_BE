package com.example.casestudy6.repository;

import com.example.casestudy6.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountRepoF extends PagingAndSortingRepository<Account,Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM Account WHERE id= :account2_id")
    Account getFriendToBlock(@Param("account2_id") long account2_id);





    @Query(nativeQuery = true,value = "SELECT * FROM Account WHERE user_name= :user_name")
    Account findAccountByUserName(@Param("user_name") String user);
    @Query(nativeQuery = true,value = "SELECT * FROM Account WHERE id=:id")
    Account findAccountById(@Param("id") long id);
    @Query(nativeQuery = true,value = "SELECT * FROM Account WHERE first_name = :first_name or last_name =:first_name")
    List<Account> findByName(@Param("first_name") String first_name);
}
