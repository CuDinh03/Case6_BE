package com.example.casestudy6.service.impl;

import com.example.casestudy6.model.Comment;
import com.example.casestudy6.model.Img;
import com.example.casestudy6.model.Status;
import com.example.casestudy6.repository.ICommentRepo;
import com.example.casestudy6.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CommentService implements ICommentService<Comment> {

    @Autowired
    ICommentRepo iCommentRepo;

    @Autowired
    StatusService statusService;

    @Override
    public void save(Comment comment) {
        iCommentRepo.save(comment);
    }

    @Override
    public void saveComment(Comment comments, Long id) {
      iCommentRepo.save(comments);
      Comment comment = findLastComment();
      iCommentRepo.saveComment(id,comment.getId());
    }

    @Override
    public Iterable<Comment> findAllByStatusId(Long id) {
       return iCommentRepo.findAllByStatusId(id);

    }

//    @Override
//    public Comment findLastComment() {
//        return null;
//    }

    @Override
    public Iterable<Comment> findComments() {
        return iCommentRepo.findComments();
    }

    @Override
    public Comment findLastComment() {
        return iCommentRepo.findLastComment();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return iCommentRepo.findById(id);
    }


}
