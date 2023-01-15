package com.example.casestudy6.service;


import com.example.casestudy6.model.Comment;

import java.util.ArrayList;
import java.util.List;

public interface ICommentService<T> {

    void save(Comment comments, Long id);

    Iterable<T> findAllByStatusId(Long id);

    Iterable<T> findComments();



    T findLastComment();
}
