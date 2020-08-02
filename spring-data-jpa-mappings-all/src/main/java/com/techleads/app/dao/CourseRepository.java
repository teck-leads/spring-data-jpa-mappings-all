package com.techleads.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.techleads.app.model.Course;
@Transactional
@Repository
public class CourseRepository {
	@Autowired
	private EntityManager entityManager;
	
	public Course findById(Integer id) {
		Course course = entityManager.find(Course.class, id);
		return course;
	}
	
	public void deleteById(Integer id) {
		Course course = findById(id);
		
		entityManager.remove(course);
	}
	public Course inserUpdate(Course course) {
		if(StringUtils.isEmpty(course.getId())) {
			entityManager.persist(course);
		}else {
			entityManager.merge(course);
		}
		return course;
	}
	public  void playWithEntityManger() {
		Course course = new Course("PersistMethod-Course");
		entityManager.persist(course);
		entityManager.flush();//changes will go the db
		course.setName("PersistMethod-Course-Updated"); //this also will be updated even it is not requested to save
		entityManager.flush();//all the above changes will go the db and save
		entityManager.refresh(course);
		//entityManager.clear();//clear everything and don't track anything
		course.setName("PersistMethod-Course-do not track this change: detach");
		entityManager.detach(course);
		
	}
	
	public List<Course> findAll(){
		TypedQuery<Course> createNamedQuery = entityManager.createNamedQuery("FIND_ALL_COURSES", Course.class);
		List<Course> courses = createNamedQuery.getResultList();
		return courses;
	}
	

}
