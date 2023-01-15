package com.example.casestudy6.controller;

import com.example.casestudy6.model.Comment;
import com.example.casestudy6.service.ICommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
@CrossOrigin("*")
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    ICommentService iCommentService;


    @PostMapping("/{id}")
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comments, @PathVariable("id") Long id) {
        comments.setPostDay(LocalDateTime.now());
        iCommentService.save(comments, id);
        return new ResponseEntity(iCommentService.findLastComment(),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> findById(@PathVariable("id") Long id){
        ArrayList<Iterable> result = new ArrayList<>();
        Iterable<Comment> comments = iCommentService.findAllByStatusId(id);
        result.add(comments);
        return new ResponseEntity(result, HttpStatus.OK);
    }


}
