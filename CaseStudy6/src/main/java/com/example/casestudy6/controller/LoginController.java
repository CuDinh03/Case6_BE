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

import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<List<Object>> login(@RequestBody Account account) {
        List<Object> result = new ArrayList<>();
        JwtResponse jwtResponse;
        if (accountService.checkLogin(account) == 1) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(account.getUserName(), account.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtService.createToken(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Account currentUser = accountService.findByUserName(account.getUserName());
            jwtResponse = new JwtResponse();
            jwtResponse.setToken(token);
            jwtResponse.setId(currentUser.getId());
            jwtResponse.setUserName(currentUser.getUserName());
            jwtResponse.setEmail( currentUser.getEmail());
            jwtResponse.setPhoneNumber(currentUser.getPhoneNumber());
            jwtResponse.setImg(currentUser.getImg());
            jwtResponse.setFirstName(currentUser.getFirstName());
            jwtResponse.setLastName(currentUser.getLastName());
            jwtResponse.setAddress(currentUser.getAddress());
            jwtResponse.setGender(currentUser.getGender());
            jwtResponse.setBirthDay(currentUser.getBirthDay());
            jwtResponse.setRoles(userDetails.getAuthorities());
            result.add(1);
            result.add(jwtResponse);
            return new ResponseEntity<>(result, HttpStatus.OK);
//            return ResponseEntity.ok(new JwtResponse(token, currentUser.getId(), currentUser.getUserName(), currentUser.getEmail(), currentUser.getPhoneNumber(), currentUser.getImg(), currentUser.getFirstName(), currentUser.getLastName(), currentUser.getAddress(), currentUser.getGender(), currentUser.getBirthDay(), userDetails.getAuthorities()));
        } else if (accountService.checkLogin(account) == 2) {
            //tai khoan bi block
            result.add(2);
            result.add(jwtService);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            //sai tai khoan hoac mat khau
            result.add(3);
            result.add(jwtService);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}

