package com.example.casestudy6.repository;

import com.example.casestudy6.model.Account;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface IAccountRepo extends PagingAndSortingRepository<Account, Long> {
    Account findByUserName(String userName);
    Account findByEmail(String email);

}
