package com.example.casestudy6.service.impl;

import com.example.casestudy6.model.Friends;
import com.example.casestudy6.service.IFriendService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FriendService implements IFriendService {

    @Override
    public Iterable<Friends> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Friends> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Friends> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Friends> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Friends> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Friends> findAll() {
        return null;
    }

    @Override
    public Iterable<Friends> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Friends entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Friends> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
