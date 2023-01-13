package com.example.casestudy6.service.impl;

import com.example.casestudy6.model.Comment;
import com.example.casestudy6.repository.CommentRepo;
import com.example.casestudy6.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService implements ICommentService<Comment> {
    @Autowired
    CommentRepo commentRepo;
    @Override
    public Iterable<Comment> findAll() {
        return commentRepo.findAll();
    }

    @Override
    public void save(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Integer numberOfComment() {
        return commentRepo.numberOfComment();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepo.findById(id);
    }

}