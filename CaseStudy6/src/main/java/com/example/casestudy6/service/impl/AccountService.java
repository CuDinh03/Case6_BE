package com.example.casestudy6.service.impl;

import com.example.casestudy6.model.Account;
import com.example.casestudy6.repository.IAccountRepo;
import com.example.casestudy6.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountRepo iAccountRepo;


    public Boolean existsByEmail(String email) {
        return iAccountRepo.existsByEmail(email);
    }


    public Boolean existsByUserName(String userName) {
        return iAccountRepo.existsByUserName(userName);
    }

    @Override
    public void save(Account account) {
        iAccountRepo.save(account);
    }

    @Override
    public Iterable<Account> findAll() {
        return iAccountRepo.findAll();
    }

    @Override
    public Account findByUserName(String userName) {
        return iAccountRepo.findByUserName(userName);
    }

    @Override
    public Account findByEmail(String email) {
        return iAccountRepo.findByEmail(email);
    }

    @Override
    public Optional<Account> findById(Long id) {
        return iAccountRepo.findById(id);
    }

    @Override
    public boolean checkLogin(Account account) {
        Iterable<Account> accounts = this.findAll();
        boolean isCorrectUser = false;
        for (Account currentUser : accounts) {
            if (currentUser.getUserName().equals(account.getUserName())
                    && account.getPassword().equals(currentUser.getPassword())) {
                isCorrectUser = true;
            }
        }
        return isCorrectUser;
    }

    @Override
    public boolean isRegister(Account account) {
        boolean isRegister = false;
        Iterable<Account> accounts = this.findAll();
        for (Account currentUser : accounts) {
            if (account.getUserName().equals(currentUser.getUserName())) {
                isRegister = true;
                break;
            }
        }
        return isRegister;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) {
        Account account = iAccountRepo.findByUserName(userName);
        if (account == null) {
            throw new UsernameNotFoundException(userName);
        }
        if (this.checkLogin(account)) {
            return new User(account.getUserName(), account.getPassword(), (Collection<? extends GrantedAuthority>) account.getRole());
        }
        boolean enable = false;
        boolean accountNonExpired = false;
        boolean credentialsNonExpired = false;
        boolean accountNonLocked = false;
        return new org.springframework.security.core.userdetails.User(account.getUserName(),
                account.getPassword(), enable, accountNonExpired, credentialsNonExpired,
                accountNonLocked, null);
    }
}
