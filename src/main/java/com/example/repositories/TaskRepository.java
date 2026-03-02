package com.example.repositories;

import com.example.entities.Task;

public class TaskRepository extends AbstractRepository <Task> implements Repository<Task> {
    private static TaskRepository instance;

    private TaskRepository() {

    }

    public static TaskRepository getInstance() {
        if(instance == null) {
            instance = new TaskRepository();
        }
        return instance;
    }
}
