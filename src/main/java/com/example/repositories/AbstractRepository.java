package com.example.repositories;

import com.example.entities.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class AbstractRepository <T extends BaseEntity> implements Repository<T> {
    protected List<T> storage = new ArrayList<>();

    public void create(T entity) {
        storage.add(entity);
    }

    public T read(int id) {
        for(T entity : storage) {
            if(entity.getId() == id){
                return entity;
            }
        }
        return null;
    }

    public void update(T entity) {
        for(int i = 0; i < storage.size(); i++) {
            if(storage.get(i).getId() == entity.getId()) {
                storage.set(i, entity);
                return;
            }
        }
        throw new IllegalArgumentException("Entity with id " + entity.getId() + " not found");
    }

    public void delete(int id) {
        boolean removed = storage.removeIf(entity -> entity.getId() == id);
        if(!removed) {
            throw new IllegalArgumentException("Entity with id " + id + " not found");
        }
    }

    public List<T> findAll() {
        return new ArrayList<>(storage);
    }

    public List<T> getAll() {
        return findAll();
    }

    public List<T> getAll(Comparator<T> comparator) {
        List<T> list = getAll();
        list.sort(comparator);
        return list;
    }
}
