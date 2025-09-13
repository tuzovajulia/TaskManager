package com.example.services;

import com.example.entities.Person;
import com.example.entities.Task;
import com.example.exceptions.DuplicateEntityException;
import com.example.exceptions.NotFoundException;
import com.example.exceptions.ValidationException;
import com.example.repositories.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PersonService {
    private final Repository<Person> personRep;

    public PersonService(Repository<Person> personRep) {
        this.personRep = personRep;
    }

    public Person createPerson(String firstName, String lastName, String email) {
        if(firstName == null || firstName.strip().isEmpty()) {
            throw new ValidationException("First name can't be null");
        }

        if(lastName == null || lastName.strip().isEmpty()) {
            throw new ValidationException("Last name can't be null");
        }

        if(email == null || !email.contains("@")) {
            throw new ValidationException("Email is invalid");
        }

        if(findByEmail(email) != null) {
            throw new DuplicateEntityException("Person with email " + email + " already exists");
        }

        Person person = new Person(firstName, lastName, email, new ArrayList<>());
        personRep.create(person);
        return person;
    }

    public Person getPerson(UUID id) {
        if(id == null) throw new ValidationException("Id is null");
        Person p = personRep.read(id);
        if(p == null) throw new NotFoundException("Person not found with id " + id);
        return p;
    }

    public List<Person> getAllPersons() {
        return new ArrayList<>(personRep.getAll());
    }

    public void updatePerson(Person person) {
        if(person == null || person.getId() == null) {
            throw new ValidationException("Person or id is null");
        }

        if(person.getFirstName() == null || person.getFirstName().strip().isEmpty()){
            throw new ValidationException("First name can't be null");
        }

        if(person.getLastName() == null || person.getLastName().strip().isEmpty()) {
            throw new ValidationException("Last name can't be null");
        }

        if(person.getEmail() == null || !person.getEmail().contains("@")) {
            throw new ValidationException("Email is invalid");
        }

        personRep.update(person);
    }

    public void deletePerson(UUID id) {
        if(id == null) {
            throw new ValidationException("Id is null");
        }

        personRep.delete(id);
    }

    public Person findByEmail(String email) {
        if(email == null || email.trim().isEmpty()) return null;
        String target = email.trim().toLowerCase();

        for(Person p: personRep.getAll()) {
            if(p.getEmail() !=null && p.getEmail().trim().toLowerCase().equals(target)) {
                return p;
            }
        }
        return null;
    }

    public void addTaskToPerson(UUID personId, Task task) {
        if(personId == null) throw new ValidationException("Person id is null");
        if(task == null) throw new ValidationException("Task is null");

        Person person = getPerson(personId);

        if(person == null) throw new IllegalArgumentException("Person not found");

        if(person.getTasks() == null) {
            person.setTasks(new ArrayList<>());
        }

        for(Task t : person.getTasks()) {
            if(t.getId().equals(task.getId())) {
                throw new DuplicateEntityException("Task already assigned to this person");
            }
        }

        person.getTasks().add(task);
        personRep.update(person);
    }

}
