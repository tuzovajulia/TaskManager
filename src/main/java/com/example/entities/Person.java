package com.example.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Person extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private String email;
    private List<Task> tasks;

    public Person() {
    }

    public Person(String firstName, String lastName, String email,
                  List<Task> tasks) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.tasks = tasks;
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

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person)o;
        return Objects.equals(getId(), person.getId()) &&
                Objects.equals(email, person.email);
    }

    public int hashCode() {
        return Objects.hash(getId(), email);
    }

    @Override
    public String toString() {
        return "Person{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
