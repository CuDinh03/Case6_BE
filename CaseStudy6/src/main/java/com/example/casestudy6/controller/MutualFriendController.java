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
@RequestMapping("/mutualfriend")
public class MutualFriendController {
    @Autowired
    IFriendService iFriendService;
    @GetMapping("/{account1}/{account2_id}")
    public ResponseEntity<List<FriendList>> getMUtualFriend(@PathVariable long account1, @PathVariable long account2_id){
        return new ResponseEntity<List<FriendList>>(iFriendService.getMutualFriend(account1, account2_id), HttpStatus.OK);
    }

}
