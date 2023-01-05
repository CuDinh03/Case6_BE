package com.example.casestudy6.controller;

import com.example.casestudy6.model.Account;
import com.example.casestudy6.model.Role;
import com.example.casestudy6.service.impl.AccountService;
import com.example.casestudy6.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin("*")
@Validated
@RequestMapping("/registers")
public class RegisterController {
    @Autowired
    AccountService accountService;
    @Autowired
    RoleService roleService;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody Account account, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Iterable<Account> accounts = accountService.findAll();
        for (Account currentUser : accounts) {
            if (currentUser.getUserName().equals(account.getUserName())) {
                return new ResponseEntity<>("Tên người dùng đã tồn tại", HttpStatus.BAD_REQUEST);
            }
            if (currentUser.getEmail().equals(account.getEmail())) {
                return new ResponseEntity<>("Email đã tồn tại", HttpStatus.BAD_REQUEST);
            }
        }
        Role role = new Role();
        role.setName("ROLE_USER");
        role.setId(2);

//        return new ResponseEntity<>(account, HttpStatus.OK);
//        if (account.getRole() != null) {
//            Role role = roleService.findByName("ROLE_ADMIN");
//            Set<Role> roles = new HashSet<>();
//            roles.add(role);
//            account.setRole(role);
//        } else {
//            Role role1 = roleService.findByName("ROLE_USER");
//            Set<Role> roles1 = new HashSet<>();
//            role.setName("ROLE_USER");
//            role.setId(1);
//        }
        accountService.save(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<Account> getProfile(@PathVariable Long id) {
        Optional<Account> userOptional = this.accountService.findById(id);
        return userOptional.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
