package com.krittapas.learning_spring_boot.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.krittapas.learning_spring_boot.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class PersonRepository implements PersonDAO {

    private EntityManager entityManager;

    @Autowired
    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
    }

    @Override
    public Person get(Integer id){
        return entityManager.find(Person.class, id);
    }

    @Override
    public List<Person> getAll(){
        TypedQuery<Person> query = entityManager.createQuery("from Person", Person.class);
        return List.of(query.getResultList().toArray(new Person[0]));
    }

    @Override
    @Transactional
    public void update(Person person){
        entityManager.merge(person);
    }
}
