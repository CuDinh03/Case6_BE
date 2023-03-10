package com.example.casestudy6.controller;

import com.example.casestudy6.model.Status;
import com.example.casestudy6.service.impl.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/statuses")
public class StatusController {
    @Autowired
    StatusService statusService;

    @GetMapping
    public ResponseEntity<ArrayList<?>> findALL() {
        ArrayList<Iterable> result = new ArrayList<>();
//        ArrayList<Status> statusOwner = (ArrayList<Status>) statusService.findAllByOwner(currentId);
//        ArrayList<Status> statusFriend = (ArrayList<Status>) statusService.findAllByOwnerFriend(currentId);
//        ArrayList<Status> statusStranger = (ArrayList<Status>) statusService.findAllByStranger(currentId);
        Iterable<Status> listStatus = statusService.findAll();
//        listStatus.addAll(statusOwner);
//        listStatus.addAll(statusFriend);
//        listStatus.addAll(statusStranger);
        result.add(listStatus);
//        ArrayList<Iterable<Image>> listImage = new ArrayList<>();
//        ArrayList<Integer> listNumberOfLike = new ArrayList<>();
//        ArrayList<Integer> listNumberOfComment = new ArrayList<>();
//        for (Status status : listStatus) {
//            Iterable<Image> images = imageService.findAllByStatus(status.getId());
//            listImage.add(images);
//            Integer numberOfLike = likeStatusService.findNumberOfLikeByStatus(status.getId());
//            if (numberOfLike == null) {
//                numberOfLike = 0;
//            }
//            listNumberOfLike.add(numberOfLike);
//            Integer numberOfComment = commentService.findNumberOfComment(status.getId());
//            if (numberOfComment == null) {
//                numberOfComment = 0;
//            }
//            listNumberOfComment.add(numberOfComment);
//        }
//        result.add(listImage);
//        result.add(listNumberOfLike);
//        result.add(listNumberOfComment);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArrayList<?>> findAllByAccountId(@PathVariable("id") Long id) {
        Optional<Status> status = statusService.findById(id);
        if (!status.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ArrayList<Iterable> result = new ArrayList<>();
        Iterable<Status> statuses = statusService.findAllByAccountId(id);;
        ArrayList<Integer> listNumberOfLike = new ArrayList<>();
        result.add(statuses);
//        Iterable<Img> images = imageService.findAllByStatus(status.get().getId());
//        result.add(images);
//        Integer numberOfLike = likeStatusService.findNumberOfLikeByStatus(status.get().getId());
//        if (numberOfLike == null) {
//            numberOfLike = 0;
//        }
//        listNumberOfLike.add(numberOfLike);
//        result.add(listNumberOfLike);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Status> saveStatus(@RequestBody Status status) {
        status.setPostDay(LocalDateTime.now());
        statusService.save(status);
        return new ResponseEntity(statusService.findLastStatus(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> updateStatus(@PathVariable Long id, @RequestBody Status status) {
        Optional<Status> oldStatus = statusService.findById(id);
        if (!oldStatus.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        status.setId(oldStatus.get().getId());
        status.setAccount(oldStatus.get().getAccount());
        status.setPostDay(oldStatus.get().getPostDay());
        statusService.save(status);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Status> deleteComment(@PathVariable Long id) {
        Optional<Status> status1 = statusService.findById(id);
        Status status = status1.get();
        if (!status1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        status.setStatus(4);
        statusService.save(status);
        return new ResponseEntity<>(status, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<Status>findById(@PathVariable("id") Long id) {
        Optional<Status> status = statusService.findById(id);
        System.out.println(status);
        if (!status.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(status, HttpStatus.OK);
    }
}
