package com.techleads.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.techleads.app.SpringDataJpaMappingsAllApplication;
import com.techleads.app.model.Course;

@SpringBootTest(classes = SpringDataJpaMappingsAllApplication.class)

class NavtiveQueries {
	@Autowired
	EntityManager courseRepo;

	
	
	@Test
	void nativeQuerySelectAll() {
		System.out.println("{Start: inside JunitTest: NativeQuery}=> nativeQuerySelectAll() ");
		Query createNativeQuery = courseRepo.createNativeQuery("SELECT  ID , NAME,CREATED_DATE,LAST_UPDATED FROM COURSE", Course.class);
		List<?> resultList = createNativeQuery.getResultList();
		resultList.forEach(System.out::println);
		System.out.println("{End: inside JunitTest: NativeQuery}=> nativeQuerySelectAll() ");
	}
	
	@Test
	void nativeQueryByParam() {
		System.out.println("{Start: inside JunitTest: NativeQuery}=> nativeQueryByParam() ");
		Query createNativeQuery = courseRepo.createNativeQuery("SELECT  ID , NAME,CREATED_DATE,LAST_UPDATED FROM COURSE WHERE ID=?", Course.class);
		createNativeQuery.setParameter(1, 103);
		List<?> resultList = createNativeQuery.getResultList();
		resultList.forEach(System.out::println);
		System.out.println("{End: inside JunitTest: NativeQuery}=> nativeQueryByParam() ");
	}
	
	@Test
	void nativeQueryByNamedParam() {
		System.out.println("{Start: inside JunitTest: NativeQuery}=> nativeQueryByNamedParam() ");
		Query createNativeQuery = courseRepo.createNativeQuery("SELECT  ID , NAME,CREATED_DATE,LAST_UPDATED FROM COURSE WHERE ID=:myId", Course.class);
		createNativeQuery.setParameter("myId", 102);
		List<?> resultList = createNativeQuery.getResultList();
		resultList.forEach(System.out::println);
		System.out.println("{End: inside JunitTest: NativeQuery}=> nativeQueryByNamedParam() ");
	}
		

}
