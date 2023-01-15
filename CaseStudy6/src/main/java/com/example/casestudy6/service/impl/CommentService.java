package com.example.casestudy6.service.impl;

import com.example.casestudy6.model.Comment;
import com.example.casestudy6.repository.ICommentRepo;
import com.example.casestudy6.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService<Comment> {

    @Autowired
    ICommentRepo iCommentRepo;

    @Autowired
    StatusService statusService;
    @Override
    public void save(Comment comments) {
      iCommentRepo.save(comments);
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
    public Iterable<Comment> findLastComment() {
        return iCommentRepo.findComments();
    }
}
