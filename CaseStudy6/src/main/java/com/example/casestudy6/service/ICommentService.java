package com.example.casestudy6.service;


import com.example.casestudy6.model.Comment;

import java.util.List;

public interface ICommentService<T> {
    void save (Comment comment);

    Iterable<T> findAll();
}
