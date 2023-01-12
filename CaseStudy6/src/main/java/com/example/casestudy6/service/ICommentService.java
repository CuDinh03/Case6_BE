package com.example.casestudy6.service;

import com.example.casestudy6.model.Comment;

import java.util.Optional;

public interface ICommentService<C> {
    Iterable<C> findAll();

    void save(C c);

    void remove(Long id);

    Integer numberOfComment();
}
