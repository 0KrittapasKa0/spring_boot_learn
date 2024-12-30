package com.krittapas.learning_spring_boot.repository;

import java.util.List;

import com.krittapas.learning_spring_boot.entity.Person;

public interface PersonDAO {
    void save(Person person);
    void delete(Integer id);
    Person get(Integer id);
    List<Person> getAll();
    void update(Person person);
}
