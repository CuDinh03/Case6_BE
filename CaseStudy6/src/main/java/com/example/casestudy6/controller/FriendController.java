package com.example.casestudy6.controller;


import com.example.casestudy6.model.DTO.FriendList;
import com.example.casestudy6.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping()
public class FriendController {
    @Autowired
    IFriendService iFriendService;
    @GetMapping("/{account1}")
    public ResponseEntity<List<FriendList>> getAllFriends(@PathVariable String account1){
        return new ResponseEntity<>(iFriendService.getAll(account1), HttpStatus.OK);
    }
    @GetMapping("/profile/{username}")
    public  ResponseEntity<FriendList> getAccountByUserName(@PathVariable String username){
        return new ResponseEntity<>(iFriendService.getAccountByUserName(username), HttpStatus.OK);
    }
//    @PostMapping()
//    public  ResponseEntity<?> addFriend(@RequestBody Friends friends){
//        iFriendService.addFriend(friends);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
    @PostMapping ("/{account1}/{account2_id}")
    public ResponseEntity<?> blockFriend(@PathVariable int account1, @PathVariable long account2_id){
        iFriendService.blockFriend(account1,account2_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
