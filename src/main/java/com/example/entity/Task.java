package com.example.entity;

import java.time.LocalDate;

public class Task {
    private int id;
    private String name;
    private String description;
    private Priority priority;
    private LocalDate createdDate;
    private LocalDate endedDate;
    private Person author;
    private Person assignee;
    private Status status;

    public Task() {

    }

    public Task(int id, String name, Priority priority, String description,
                LocalDate createdDate, LocalDate endedDate, Person author,
                Person assignee, Status status) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.description = description;
        this.createdDate = createdDate;
        this.endedDate = endedDate;
        this.author = author;
        this.assignee = assignee;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", createdDate=" + createdDate +
                ", endedDate=" + endedDate +
                ", author='" + author + '\'' +
                ", assignee='" + assignee + '\'' +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getEndedDate() {
        return endedDate;
    }

    public void setEndedDate(LocalDate endedDate) {
        this.endedDate = endedDate;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
