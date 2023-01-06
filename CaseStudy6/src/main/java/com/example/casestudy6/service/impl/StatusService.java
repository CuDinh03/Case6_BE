package com.example.casestudy6.service.impl;

import com.example.casestudy6.model.Status;
import com.example.casestudy6.repository.StatusRepo;
import com.example.casestudy6.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusService implements IStatusService<Status> {
    @Autowired
    StatusRepo statusRepo;

    @Override
    public Iterable<Status> findAll() {
        return statusRepo.findAll();
    }

    @Override
    public Optional<Status> findById(Long id) {
        return statusRepo.findById(id);
    }

    @Override
    public void save(Status status) {
        statusRepo.save(status);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Status findLastStatus() {
        return statusRepo.findLastStatus();
    }

    @Override
    public Iterable<Status> findByAccountId(Long id) {
        return statusRepo.findByAccountId(id);
    }
}
