package com.techleads.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.techleads.app.SpringDataJpaMappingsAllApplication;
import com.techleads.app.model.Course;

@SpringBootTest(classes = SpringDataJpaMappingsAllApplication.class)

class JPQLTest {
	@Autowired
	EntityManager courseRepo;

	
	
	@Test
	void findAllJPQL() {
		System.out.println("{Start: inside JunitTest: JPQL}=> findAllJPQL() ");
		//List<Course> courses = courseRepo.createQuery("SELECT C FROM COURSE C", Course.class).getResultList();
		 List<Course> courses = courseRepo.createNamedQuery("FIND_ALL_COURSES", Course.class).getResultList();
		courses.forEach(System.out::println);
		System.out.println("{End: inside JunitTest: JPQL}=> selectAllCourses() ");
		
	}
	@Test
	void whereClausJPQL() {
		System.out.println("{Start: inside JunitTest: JPQL}=> whereClausJPQL() ");
		//List<Course> courses = courseRepo.createQuery("SELECT C FROM COURSE C where C.name like '%Kuber%' ", Course.class).getResultList();
		List<Course> courses = courseRepo.createNamedQuery("FIND_ALL_COURSES_CONTAINS_Kuber", Course.class).getResultList();
		courses.forEach(System.out::println);
		System.out.println("{End: inside JunitTest: JPQL}=> whereClausJPQL() ");
		
	}
		

}
