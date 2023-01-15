package com.example.casestudy6.repository;

import com.example.casestudy6.model.Account;
import com.example.casestudy6.model.dto.FriendList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface IAccountRepo extends PagingAndSortingRepository<Account, Long> {
    Account findByUserName(String userName);
    Account findByEmail(String email);

}
