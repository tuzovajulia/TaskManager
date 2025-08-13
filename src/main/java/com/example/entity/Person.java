package com.example.entity;

import java.util.List;
import java.util.Objects;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Task> tasks;

    public Person() {

    }

    public Person(int id, String firstName, String lastName, String email,
                  List<Task> tasks) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", tasks=" + tasks +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person)o;
        return Objects.equals(id, person.id);
    }

    public int hashCode() {
        return Objects.hash(id);
    }
}
