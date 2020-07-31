package com.techleads.app;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.techleads.app.dao.PersonDao;
import com.techleads.app.model.Person;
@Component
public class PersonRunner implements CommandLineRunner {
@Autowired
	private PersonDao dao;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("==========findAll(-)===============");
		List<Person> findAll = dao.findAll();
		findAll.forEach(System.out::println);
		System.out.println("==========findById(-)===============");
		Person findById = dao.findById(102);
		System.out.println(findById);
		
		System.out.println("==========deleteById(-)===============");
		int deletedById = dao.deleteById(101);
		System.out.println("Deleted rows "+deletedById);
		
		
		System.out.println("==========Save Person Entity(-)===============");
		int saved = dao.save(new Person(103, "dill", "USA", new Date()));
		System.out.println("Saved rows "+saved);
		
		System.out.println("==========findAllRowMapperLamda(-)===============");
		 findAll = dao.findAllRowMapperLamda();
		findAll.forEach(System.out::println);
		
		System.out.println("==========Update Person Entity(-)===============");
		int updated = dao.updatePerson(new Person(103, "dill", "USA, CANADA", new Date()));
		System.out.println("Updated rows "+updated);
		
		System.out.println("==========After updated findAllRowMapper(-)===============");
		 findAll = dao.findAllRowMapper();
		findAll.forEach(System.out::println);
		System.exit(0);
	
	}

}
