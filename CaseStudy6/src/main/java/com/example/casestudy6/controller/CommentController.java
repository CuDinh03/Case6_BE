package com.example.casestudy6.controller;
import com.example.casestudy6.model.Comment;
import com.example.casestudy6.model.Status;
import com.example.casestudy6.service.impl.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
//Hiển thị toàn bộ comment
    @GetMapping
    public ResponseEntity<ArrayList<?>> findALL() {

        ArrayList<Iterable> result = new ArrayList<>();

        Iterable<Comment> listComment = commentService.findAll();

        result.add(listComment);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    // Tính tổng số comment
    @PostMapping
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
        comment.setStatus(commentService.numberOfComment());
        commentService.save(comment);
        return new ResponseEntity(commentService.numberOfComment(), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        Optional<Comment> oldComment = commentService.findById(id);
        if (!oldComment.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        comment.setId(oldComment.get().getId());
        comment.setAccount(oldComment.get().getAccount());
        comment.setStatus(oldComment.get().getStatus());
        commentService.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable Long id) {
        Optional<Comment> comment1 = commentService.findById(id);
        Comment comment = comment1.get();
        if (!comment1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        comment.setStatus(1);
        commentService.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
    @GetMapping("/one/{id}")
    public ResponseEntity<Comment>findById(@PathVariable("id") Long id) {
        Optional<Comment> comment = commentService.findById(id);
        System.out.println(comment);
        if (!comment.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(comment, HttpStatus.OK);
    }
}



