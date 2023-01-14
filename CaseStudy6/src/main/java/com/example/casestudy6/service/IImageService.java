package com.example.casestudy6.service;

import java.util.ArrayList;
import java.util.Optional;

public interface IImageService<T> {
    void save(ArrayList<T> t);

    Iterable<T> findAllByStatusId(Long id);
}
