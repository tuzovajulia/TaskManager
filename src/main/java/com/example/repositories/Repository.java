package com.example.repositories;

import java.util.List;
import java.util.UUID;

public interface Repository<T> {
    void create(T entity);
    T read(UUID id);
    void update(T entity);
    void delete(UUID id);
    List<T> getAll();
}
