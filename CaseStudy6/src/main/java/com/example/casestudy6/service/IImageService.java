package com.example.casestudy6.service;

import java.util.ArrayList;
import java.util.Optional;

public interface IImageService<T> {
    void saveAll(ArrayList<T> t);

    Iterable<T> findAllByStatusId(Long id);

    Optional<T> findById (Long id);

    default void updateImage(Long id, ArrayList<T> t) {
    }
}
