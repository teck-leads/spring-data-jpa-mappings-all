package com.techleads.app.runner;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.techleads.app.dao.PersonJPARepository;
import com.techleads.app.model.Person;

@Component
public class PersonJPARepositoryRunner implements CommandLineRunner {
	@Autowired
	private PersonJPARepository personJPARespository;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("==========findAll From JPA Repository===============");
		List<Person> findAll = personJPARespository.findAll();
		findAll.forEach(System.out::println);
		System.out.println("==========findById(-) From JPA Repository===============");
		Person findById = personJPARespository.findById(102);
		System.out.println(findById);
		System.out.println("==========Merge entity Person(-) From JPA Repository===============");
		Person person = personJPARespository.merge(new Person(101, "madhav", "India", new Date()));
		System.out.println(person);
		System.out.println("==========Save entity Person(-) From JPA Repository===============");
		Person insert = personJPARespository.merge(new Person("dill", "USA", new Date()));
		System.out.println(insert);

		personJPARespository.remove(1001);
		
		System.out.println("==========findAll before exit From JPA Repository===============");
		 findAll = personJPARespository.findAll();
		findAll.forEach(System.out::println);

		// System.exit(0);

	}

}
