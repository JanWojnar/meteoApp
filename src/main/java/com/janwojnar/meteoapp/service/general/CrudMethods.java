package com.janwojnar.meteoapp.service.general;

import java.util.List;

public interface CrudMethods<T> {
    T save(T to);

    T update(T to);

    void remove(Long id);

    void deleteAll();

    List<T> findAll();

    T findById(Long id);
}
