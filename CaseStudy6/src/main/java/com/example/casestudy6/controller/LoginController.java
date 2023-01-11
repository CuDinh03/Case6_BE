package com.example.casestudy6.controller;

import com.example.casestudy6.model.Account;
import com.example.casestudy6.model.dto.JwtResponse;
import com.example.casestudy6.service.impl.AccountService;
import com.example.casestudy6.service.impl.JwtService;
import com.example.casestudy6.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@CrossOrigin("*")
public class LoginController {
    @Autowired
    AccountService accountService;

    @Autowired
    RoleService roleService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account account) {
        if (!accountService.isRegister(account)) {
            return new ResponseEntity<>("1", HttpStatus.NOT_FOUND);
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUserName(), account.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.createToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Account currentUser = accountService.findByUserName(account.getUserName());
        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), currentUser.getUserName(), currentUser.getEmail(), currentUser.getPhoneNumber(), currentUser.getImg(), currentUser.getFirstName(), currentUser.getLastName(), currentUser.getGender(),currentUser.getAddress(), currentUser.getBirthDay(), userDetails.getAuthorities()));
    }
}

