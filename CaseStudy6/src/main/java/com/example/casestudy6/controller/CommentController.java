package com.example.casestudy6.controller;

import com.example.casestudy6.service.impl.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CommentController {
    @Autowired
    CommentService commentService;





}
