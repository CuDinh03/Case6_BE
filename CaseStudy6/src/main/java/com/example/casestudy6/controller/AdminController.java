package com.example.casestudy6.controller;

import com.example.casestudy6.model.Account;
import com.example.casestudy6.model.DTO.ChangePassword;
import com.example.casestudy6.service.impl.AccountService;
import com.example.casestudy6.service.impl.JwtService;
import com.example.casestudy6.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Validated
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {
    @Autowired
    AccountService accountService;

    @Autowired
    RoleService roleService;

    @GetMapping("/users")
    public ResponseEntity<Iterable<Account>> showAllUser() {
        Iterable<Account> accounts = accountService.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PutMapping("/disableUser/{id}")
    public ResponseEntity<Boolean> disableUser(@PathVariable long id) {
        Optional<Account> account = this.accountService.findById(id);
        account.get().setStatus(1);
        accountService.save(account.get());
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping("/undisableUser/{id}")
    public ResponseEntity<Boolean> undisableUser(@PathVariable long id) {
        Optional<Account> account = this.accountService.findById(id);
        account.get().setStatus(0);
        accountService.save(account.get());
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

//    @GetMapping("/users/{page}")
//    public ResponseEntity<Page<Account>> getAllPage(@PathVariable int page) {
//        Page<Account> accounts = accountService.getAllPage(PageRequest.of(page, 20, Sort.by("name")));
//        return new ResponseEntity<>(accounts, HttpStatus.OK);
//
//    }
}

