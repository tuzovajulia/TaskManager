package com.example.repository;

import com.example.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements Repository <Person> {
    private List<Person> persons = new ArrayList<>();
    private int nextId = 1;

    public void create (Person person){
        if (person == null){
            throw new IllegalArgumentException("Person can't be null");
        }
        if (person.getId() <= 0){
            person.setId(nextId);
            nextId++;
        } else {
            for (Person p : persons){
                if (p.getId() == person.getId()){
                    throw new IllegalArgumentException("Person with this Id already exists");
                }
            }
        }
        persons.add(person);

    }

    public Person read (int id){
        for (Person p: persons){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void update (Person person){
        if (person == null || person.getId() <= 0){
            throw new IllegalArgumentException("Invalid person to update");
        }

        if (person.getEmail() == null || !person.getEmail().contains("@")){
            throw new IllegalArgumentException("Email must contain '@'");
        }

        for (int i = 0; i < persons.size(); i++){
            if (persons.get(i).getId() == person.getId()){
                persons.set(i, person);
                return;
            }
        }
        throw new IllegalArgumentException("Person with id " + person.getId() + " not found");

    }

    public void delete (int id){
        boolean removed = persons.removeIf(person -> person.getId() == id);
        if (removed){
            System.out.println("Person was delete");
        } else {
            System.out.println("Person with id " + id + " not found");
        }
    }

    public List<Person> findAll(){
        return new ArrayList<>(persons);
    }


}
