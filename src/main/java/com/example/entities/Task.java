package com.example.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Task extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

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

    public Task(String name, String description, Priority priority,
                LocalDate createdDate, LocalDate endedDate, Person author,
                Person assignee, Status status) {
        super();
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.createdDate = createdDate;
        this.endedDate = endedDate;
        this.author = author;
        this.assignee = assignee;
        this.status = status;
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

    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Task task = (Task)o;
        return getId() == task.getId() &&
                Objects.equals(author, task.author);
    }

    public int hashCode() {
        return Objects.hash(getId(), author);
    }

    @Override
    public String toString() {
        String assigneeTasks = "";
        if(assignee != null && assignee.getTasks() != null){
            assigneeTasks = assignee.getTasks().stream()
                    .map(task -> task.getName())
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("");
        }

        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", createdDate=" + createdDate +
                ", endedDate=" + endedDate +
                ", author=" + (author != null ? author.getFirstName() + " " + author.getLastName() : null) +
                ", assignee=" + (assignee != null ? assignee.getFirstName() + " " + assignee.getLastName() : null) +
                ", assigneeTasks = [" + assigneeTasks + "]" +
                ", status=" + status +
                '}';
    }
}
