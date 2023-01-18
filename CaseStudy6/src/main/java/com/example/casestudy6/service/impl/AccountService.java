package com.example.casestudy6.service.impl;

import com.example.casestudy6.model.Account;
import com.example.casestudy6.model.dto.AccountEdit;
import com.example.casestudy6.model.DTO.FriendList;
import com.example.casestudy6.repository.IAccountRepo;
import com.example.casestudy6.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    Account account1 = new Account();
    @Autowired
    IAccountRepo iAccountRepo;


    public Page<Account> getAllPage(Pageable pageable){
        return iAccountRepo.findAll(pageable);
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
    public long checkLogin(Account account) {
        long isCorrectUser;
        Account account1 = findByUserName(account.getUserName());
        if (account1 != null && account1.getPassword().equals(account.getPassword()) && account1.getStatus() == 0 || account1.getStatus()==4|| account1.getStatus()==5||account1.getStatus()==6||account1.getStatus()==7) {
            isCorrectUser = 1;
        } else if (account1 != null && account1.getPassword().equals(account.getPassword()) && account1.getStatus() == 1) {
            isCorrectUser = 2;
        }else {
            isCorrectUser = 3;
        }
        return isCorrectUser;
//        for (Account currentUser : accounts) {
//            if (currentUser.getUserName().equals(account.getUserName())
//                    && account.getPassword().equals(currentUser.getPassword()) && currentUser.getStatus()==0) {
//                isCorrectUser = true;
//            }
//        }
//        return isCorrectUser;
//    }
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
    public void updateAccount(AccountEdit account) {
        account1 = iAccountRepo.findById(account.getId()).get();
        account1.setFirstName(account.getFirstName());
        account1.setLastName(account.getLastName());
        account1.setAddress(account.getAddress());
        account1.setGender(account.getGender());
        account1.setBirthDay(account.getBirthDay());
        account1.setPhoneNumber(account.getPhoneNumber());
        account1.setStatus(account.getStatus());
        iAccountRepo.save(account1);
    }

    @Override
    public FriendList getAccountById(Long id) {
        FriendList friendList = new FriendList();
        friendList.setStatus(iAccountRepo.findById(id).get().getStatus());
        friendList.setGender(iAccountRepo.findById(id).get().getGender());
        friendList.setAddress(iAccountRepo.findById(id).get().getAddress());
        friendList.setBirthDay(iAccountRepo.findById(id).get().getBirthDay());
        friendList.setFirstName(iAccountRepo.findById(id).get().getFirstName());
        friendList.setLastName(iAccountRepo.findById(id).get().getLastName());
        friendList.setPhoneNumber(iAccountRepo.findById(id).get().getPhoneNumber());
        friendList.setImg(iAccountRepo.findById(id).get().getImg().getName());
        friendList.setId(iAccountRepo.findById(id).get().getId());
        friendList.setUsername(iAccountRepo.findById(id).get().getUserName());
        return friendList ;
    }



    @Override
    public UserDetails loadUserByUsername(String userName) {
        Account account = iAccountRepo.findByUserName(userName);
        if (account == null) {
            throw new UsernameNotFoundException(userName);
        }
        if (this.checkLogin(account) == 1) {
            return new User(account.getUserName(), account.getPassword(), account.getRoles());
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
