package com.example.casestudy6.service;

import com.example.casestudy6.model.Account;
import com.example.casestudy6.model.dto.AccountEdit;
import com.example.casestudy6.model.dto.FriendList;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Date;
import java.util.Optional;

//Lưu ý phải chạy thư viện Security
public interface IAccountService extends UserDetailsService {
    void save(Account account);

    Iterable<Account> findAll();
    Account findByUserName(String userName);
    Account findByEmail(String email);

    Optional<Account> findById(Long id);

    boolean checkLogin(Account account);

    boolean isRegister(Account account);
    void updateAccount(AccountEdit account);
    FriendList getAccountById(Long id);

}