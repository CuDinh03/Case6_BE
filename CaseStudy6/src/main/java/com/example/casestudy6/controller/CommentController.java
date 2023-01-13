package com.example.casestudy6.controller;
import com.example.casestudy6.model.Comment;
import com.example.casestudy6.service.impl.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@CrossOrigin("*")
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping
    public ResponseEntity<ArrayList<?>> findALL() {

        ArrayList<Iterable> result = new ArrayList<>();

        Iterable<Comment> listComment = commentService.findAll();

        result.add(listComment);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}



