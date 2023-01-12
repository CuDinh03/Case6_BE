package com.example.casestudy6.controller;

import com.example.casestudy6.model.dto.FriendList;
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
    @GetMapping("/profileId/{id}")
    public  ResponseEntity<FriendList> getAccountId(@PathVariable long id) {
        return new ResponseEntity<>(iFriendService.getAccountById(id), HttpStatus.OK);
    }
    @GetMapping("/requestSent/{id}")
    public ResponseEntity<List<FriendList>> getRequestSent(@PathVariable long id){
        return new ResponseEntity<>(iFriendService.listRequestSent(id), HttpStatus.OK);
    }
    @GetMapping("/requestReceived/{id}")
    public ResponseEntity<List<FriendList>> getRequestReceived(@PathVariable long id){
        return new ResponseEntity<>(iFriendService.listRequestReceived(id), HttpStatus.OK);
    }
    @PostMapping("/addFriend/{account1}/{account2_id}")
    public  ResponseEntity<?> addFriend(@PathVariable long account1,@PathVariable long account2_id){
        iFriendService.addFriend( account1,account2_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping ("/{account1}/{account2_id}")
    public ResponseEntity<?> blockFriend(@PathVariable int account1, @PathVariable long account2_id){
        iFriendService.blockFriend(account1,account2_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/acceptRequest/{account1}/{account2_id}")
    public ResponseEntity<?> acceptRequest(@PathVariable int account1,@PathVariable long account2_id){
        iFriendService.acceptRequest(account1,account2_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{account1}/{account2_id}")
    public ResponseEntity<?> remove(@PathVariable int account1,@PathVariable long account2_id){
        iFriendService.removeFriend(account1,account2_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/find/{any}")
    public ResponseEntity<List<FriendList>> find(@PathVariable String any){
        return new ResponseEntity<>(iFriendService.getAccountByAnyT(any),HttpStatus.OK);
    }
    @GetMapping("/isFriends/{id1}/{id2}")
    public ResponseEntity<Integer> isFriends(@PathVariable long id1,@PathVariable long id2){
        return new ResponseEntity<>(iFriendService.isFriends(id1,id2),HttpStatus.OK);
    }
    @DeleteMapping("/deleteRequest/{id1}/{id2}")
    public ResponseEntity<?> removeRequest(@PathVariable long id1,@PathVariable long id2) {
        iFriendService.deleteRequest(id1,id2);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/sent/{id1}")
    public ResponseEntity<List<FriendList>> getSent(@PathVariable long id1){

        return new ResponseEntity<>(iFriendService.listRequestSent(id1),HttpStatus.OK);
    }
    @GetMapping("/received/{id1}")
    public ResponseEntity<List<FriendList>> getReceived(@PathVariable long id1){
        return new ResponseEntity<>(iFriendService.listRequestReceived(id1),HttpStatus.OK);
    }
}
