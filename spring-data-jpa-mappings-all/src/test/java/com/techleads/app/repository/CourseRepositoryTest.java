package com.techleads.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.techleads.app.SpringDataJpaMappingsAllApplication;
import com.techleads.app.dao.CourseRepository;
import com.techleads.app.model.Course;

@SpringBootTest(classes = SpringDataJpaMappingsAllApplication.class)

class CourseRepositoryTest {
	@Autowired
	CourseRepository courseRepo;

	@Test
	void findById() {
		System.out.println("{inside JunitTest}=> findById() ");
		Course course = courseRepo.findById(102);
		assertEquals("Microservices", course.getName());
	}

	@Test
	@DirtiesContext
	void deleteById() {
		System.out.println("{inside JunitTest}=> deleteById()");
		courseRepo.deleteById(102);
		assertNull(courseRepo.findById(102));
	}

	@Test
	@DirtiesContext
	void saveEntity() {
		System.out.println("{inside JunitTest}=> saveEntity()");
		Course course = courseRepo.findById(102);
		assertEquals("Microservices", course.getName());
		// update course name
		course.setName("Microservices-Updated");
		courseRepo.inserUpdate(course);
		course = courseRepo.findById(102);
		assertEquals("Microservices-Updated", course.getName());

	}
	
	
	@Test
	@DirtiesContext
	void playWithEntityManger() {
		System.out.println("{Start: inside JunitTest}=> playWithEntityManger()");
		courseRepo.playWithEntityManger();
		System.out.println("{End: inside JunitTest}=> playWithEntityManger()");
	}

}
