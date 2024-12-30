package com.krittapas.learning_spring_boot.repository;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.krittapas.learning_spring_boot.entity.Person;

@Repository
public class PersonRepository implements PersonDAO {

    private Entity entityManager;

    @Autowired
    public PersonRepository(Entity entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Person person) {
        System.out.println("Person saved with name: " + person.getfName());
    }
}
