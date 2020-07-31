package com.techleads.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.techleads.app.model.Person;
@Repository
@Transactional
public class PersonJPARepository{
	@PersistenceContext
	private EntityManager entityManager;
	public Person findById(Integer id) {
		Person person = entityManager.find(Person.class, id);
		return person;
	}
	
	
	public Person merge(Person person) {
		 person = entityManager.merge(person);
		return person;
	}
	
	public void remove(Integer id) {
		Person findById = findById(id);
		entityManager.remove(findById);
	}
	
	public List<Person> findAll() {
		TypedQuery<Person> createNamedQuery = entityManager.createNamedQuery("findAll", Person.class);
		List<Person> persons = createNamedQuery.getResultList();
		return persons;
	}

}
