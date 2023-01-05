package com.example.casestudy6.controller;

import com.example.casestudy6.model.Friends;
import com.example.casestudy6.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping()
public class FriendController {
    @Autowired
    IFriendService iFriendService;
    @GetMapping("/{account1}")
    public ResponseEntity<List<Friends>> getAllFriends(@PathVariable String account1){
        return new ResponseEntity<>(iFriendService.getAll(account1), HttpStatus.OK);
    }
    @PostMapping()
    public  ResponseEntity<?> addFriend(@RequestBody Friends friends){
        iFriendService.addFriend(friends);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
