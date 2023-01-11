package com.example.casestudy6.controller;

import com.example.casestudy6.model.Account;
import com.example.casestudy6.model.dto.ChangePassword;
import com.example.casestudy6.service.impl.AccountService;
import com.example.casestudy6.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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


    @PutMapping("/change-password")
    public ResponseEntity<Account> changePassword(@RequestBody ChangePassword changePassword) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByUserName(userDetails.getUsername());
        String newPassword;
        String oldPassword = changePassword.getOldPassword();
        if (oldPassword.equals(account.getPassword())) {
            if (changePassword.getNewPassword().equals(changePassword.getConfirmNewPassword())) {
                newPassword = changePassword.getNewPassword();
            } else {
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        account.setPassword(newPassword);
        accountService.save(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}