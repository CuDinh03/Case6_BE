package com.example.casestudy6.service;


import com.example.casestudy6.model.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ICommentService<T> {

    void save(T t);
    void saveComment(Comment comments, Long id);

    Iterable<T> findAllByStatusId(Long id);

    Iterable<T> findComments();

    T findLastComment();

    Optional<T> findById(Long id);
}
