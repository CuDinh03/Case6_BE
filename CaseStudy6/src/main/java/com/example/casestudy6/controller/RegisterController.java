package com.example.casestudy6.controller;

import com.example.casestudy6.model.Account;
import com.example.casestudy6.model.Role;
import com.example.casestudy6.model.dto.ResponseMessage;
import com.example.casestudy6.model.dto.SignUpForm;
import com.example.casestudy6.service.impl.AccountService;
import com.example.casestudy6.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@CrossOrigin("*")
@Validated
public class RegisterController {

    @Autowired
    AccountService accountService;
    @Autowired
    RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/users/{id}")
    public ResponseEntity<Account> getProfile(@PathVariable Long id) {
        Optional<Account> userOptional = this.accountService.findById(id);

        return userOptional.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<Account>> showAllUser() {
        Iterable<Account> accounts = accountService.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<List<Boolean>> register(@RequestBody SignUpForm signUpForm) {
        List<Boolean> result = new ArrayList<>();
        Account appUserByEmail = accountService.findByEmail(signUpForm.getEmail());
        Account appUserByName = accountService.findByUserName(signUpForm.getUserName());
        boolean checkUserName = appUserByName == null;
        boolean checkMail = appUserByEmail == null;
        if (checkUserName && checkMail) {
            Account account1 = new Account();
//         Creating user's account
            account1.setUserName(signUpForm.getUserName());
            account1.setEmail(signUpForm.getEmail());
            account1.setPassword(signUpForm.getPassword());
            account1.setPhoneNumber(signUpForm.getPhoneNumber());
            account1.setAddress(signUpForm.getAddress());
            account1.setBirthDay(signUpForm.getBirthDay());
            account1.setGender(signUpForm.getGender());
            account1.setFistName(signUpForm.getFistName());
            account1.setLastName(signUpForm.getLastName());
            Set<Role> roles = new HashSet<>();
            Role role = new Role();
            role.setId(2);
            roles.add(role);
            account1.setRoles(roles);
            accountService.save(account1);
            result.add(true);
            result.add(true);
        } else {
            result.add(checkUserName);
            result.add(checkMail);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
