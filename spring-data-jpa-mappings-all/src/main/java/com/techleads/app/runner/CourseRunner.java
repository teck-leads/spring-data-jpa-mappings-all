package com.techleads.app.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.techleads.app.dao.CourseRepository;
import com.techleads.app.model.Course;
@Component
public class CourseRunner implements CommandLineRunner {
@Autowired
	private CourseRepository courseRepository;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("==========findById(-) From JPA Repository===============");
		Course course = courseRepository.findById(101);
		System.out.println(course);
		System.out.println("==========findById(-) From JPA Repository===============");
		//courseRepository.deleteById(101);
		System.out.println("=====Again=====findById(-) From JPA Repository===============");
		 course = courseRepository.findById(101);
		System.out.println(course);
		
		System.out.println("==========Save or update entity(-) From JPA Repository===============");
		Course inserUpdate = courseRepository.inserUpdate(new Course("Apache Kafka"));
		System.out.println(inserUpdate);
		
		System.out.println("=========playWithEntityManger() From JPA Repository===============");
		courseRepository.playWithEntityManger();
		
		System.out.println("==========findAll() From JPA Repository===============");
		List<Course> findAll = courseRepository.findAll();
		findAll.forEach(System.out::println);
	}

}
