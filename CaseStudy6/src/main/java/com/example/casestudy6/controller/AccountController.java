package com.example.casestudy6.controller;

import com.example.casestudy6.model.Account;
import com.example.casestudy6.model.dto.AccountEdit;
import com.example.casestudy6.model.dto.ChangePassword;
import com.example.casestudy6.model.dto.FriendList;
import com.example.casestudy6.service.IAccountService;
import com.example.casestudy6.service.impl.AccountService;
import com.example.casestudy6.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin("*")
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    IAccountService iAccountService;

    @GetMapping("/allAccounts")
    public ResponseEntity<Iterable<Account>> getAllAccounts() {
        Iterable<Account> result = accountService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/changepassword")
    public ResponseEntity<Boolean> changePassword(@RequestBody ChangePassword changePassword) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByUserName(userDetails.getUsername());
        String newPassword;
        String oldPassword = changePassword.getOldPassword();
        if (oldPassword.equals(account.getPassword())) {
                newPassword = changePassword.getNewPassword();
                account.setPassword(newPassword);
                accountService.save(account);
                return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false,HttpStatus.OK);
        }
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody AccountEdit account){
        iAccountService.updateAccount(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("account/{account}")
    public ResponseEntity<FriendList> findbyid(@PathVariable long account){
        return new ResponseEntity<>(iAccountService.getAccountById(account),HttpStatus.OK);
    }
    @GetMapping("/recommend")
    public ResponseEntity<List<FriendList>> getAllUsers(){
        return new ResponseEntity<>(iAccountService.getAllUsers(),HttpStatus.OK);
    }
}
