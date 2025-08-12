package com.example.repository;

import com.example.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository implements Repository <Task> {
    private List<Task> tasks = new ArrayList<>();
    private int nextId = 1;
    public void create (Task task){
        if (task == null){
            throw new IllegalArgumentException ("Task can't be null");
        }
        if (task.getId() <= 0){
            task.setId(nextId);
            nextId++;
        } else {
            for (Task t : tasks){
                if (t.getId() == task.getId()){
                    throw new IllegalArgumentException("Task with this Id already exists");
                }
            }
        }
        tasks.add(task);
    }

    public Task read (int id){
        for (Task t : tasks){
            if (t.getId() == id){
                return t;
            }
        }
        return null;
    }

    public void update (Task task){
        if (task == null || task.getId() <= 0){
            throw new IllegalArgumentException("Invalid task to update");
        }

        if (task.getCreatedDate() != null && task.getEndedDate().isBefore(task.getCreatedDate())){
            throw new IllegalArgumentException("endeddate can't be before createdDate");
        }

        for (int i = 0; i < tasks.size(); i++){
            if (tasks.get(i).getId() == task.getId()){
                tasks.set(i, task);
                return;
            }
        }
        throw new IllegalArgumentException("Task with id " + task.getId() + "not found");
    }

    public void delete (int id){
        boolean removed = tasks.removeIf(task -> task.getId() == id);
        if (removed){
            System.out.println("Task was delete");
        } else {
            System.out.println("Task with id " + id + " not found");
        }
    }

    public List<Task> findAll(){
        return new ArrayList <> (tasks);
    }
}
