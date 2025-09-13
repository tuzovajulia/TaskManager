package com.example.services;

import com.example.entities.Person;
import com.example.entities.Status;
import com.example.entities.Task;
import com.example.exceptions.ValidationException;
import com.example.exceptions.NotFoundException;
import com.example.exceptions.DuplicateEntityException;
import com.example.repositories.Repository;

import java.util.List;
import java.util.UUID;

public class TaskService {
    private final Repository<Task> taskRep;

    public TaskService(Repository<Task> taskRep) {
        this.taskRep = taskRep;
    }

    public Task createTask(Task task) {
        if(task == null) throw new ValidationException("Task is null");
        if (task.getName() == null || task.getName().trim().isEmpty())
            throw new ValidationException("Name is required");

        for(Task existing : taskRep.getAll()) {
            if(existing.getName().equalsIgnoreCase(task.getName())){
                throw new DuplicateEntityException("Task with name " + task.getName() + " already exists");
            }
        }

        if (task.getCreatedDate() == null) {
            task.setCreatedDate(java.time.LocalDate.now());
        }

        taskRep.create(task);
        return task;
    }

    public Task getTask(UUID id) {
        if(id == null) {
            throw new ValidationException("Task id is null");
        }

        Task t = taskRep.read(id);
        if(t == null){
            throw new NotFoundException("Task not found with id " + id);
        }
        return t;
    }

    public List<Task> getAllTasks() {
        return taskRep.getAll();
    }

    public void assignTask(UUID taskId, Person person) {
        Task t = getTask(taskId);
        if(person == null) throw new ValidationException("Person is null");

        if(t.getAssignee() != null && t.getAssignee().equals(person)) {
            throw new DuplicateEntityException("Task already assigned to this person");
        }
        t.setAssignee(person);
        taskRep.update(t);
    }

    public void markCompleted(UUID taskId) {
        Task task = getTask(taskId);

        if(task.getStatus() == Status.COMPLETED) {
            throw new ValidationException("Task is already completed");
        }
        task.setStatus(Status.COMPLETED);
        taskRep.update(task);
    }

    public void updateTask(Task task) {
        if(task == null || task.getId() == null) throw new ValidationException("Invalid task");
        taskRep.update(task);
    }

    public void deleteTask(UUID id) {
        if(id == null) throw new ValidationException("Task id is null");
        taskRep.delete(id);
    }
}
