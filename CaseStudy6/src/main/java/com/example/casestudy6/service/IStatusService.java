package com.example.casestudy6.service;


import java.util.Optional;

public interface IStatusService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);

    T findLastStatus();

    Iterable<T> findAllByAccountId(Long id);

}
