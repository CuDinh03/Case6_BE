package com.example.casestudy6.service;

import com.example.casestudy6.model.Status;

import java.util.Optional;

public interface IStatusService<T> {
    Iterable<T> findAllPublicStatus();

    Iterable<T> findAllFriendStatus(Long id);

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);

    T findLastStatus();

    Iterable<T> findAllByAccountId(Long id);

    Iterable<T> findAllByGuestId(Long id);

}
