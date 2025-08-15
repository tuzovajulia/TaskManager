package com.example.repositories;

import com.example.entities.Person;

public class PersonRepository extends AbstractRepository<Person> {
    private static PersonRepository instance;

    private PersonRepository() {

    }

    public static PersonRepository getInstance() {
        if(instance == null) {
            instance = new PersonRepository();
        }
        return instance;
    }
}
