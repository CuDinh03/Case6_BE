package com.example.casestudy6.repository;

import com.example.casestudy6.model.Account;
import com.example.casestudy6.model.dto.FriendList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IAccountRepoF extends PagingAndSortingRepository<Account,Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM Account WHERE id= :account2_id")
    Account getFriendToBlock(@Param("account2_id") long account2_id);

    @Query(nativeQuery = true,value = "SELECT * FROM Account WHERE user_name= :user_name")
    Account findAccountByUserName(@Param("user_name") String user);
    @Query(nativeQuery = true,value = "SELECT * FROM Account WHERE id=:id")
    Account findAccountById(@Param("id") long id);

    @Query(nativeQuery = true,value = "SELECT * FROM account where first_name LIKE  CONCAT('%',:anyT,'%')  OR last_name LIKE CONCAT('%',:anyT,'%') OR phone_number LIKE CONCAT('%',:anyT,'%') OR address LIKE CONCAT('%',:anyT,'%') OR user_name LIKE CONCAT('%',:anyT,'%') OR email LIKE CONCAT('%',:anyT,'%') ")
    List<Account> findByAny(@Param("anyT") String anyT);

}
