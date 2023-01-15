package com.example.casestudy6.service;

import com.example.casestudy6.model.Likes;

public interface ILikesService <T>{
    void save(Likes likes, Long id);

    Iterable<T> findAllByStatusId(Long id);



    T findLastLikes();
}
