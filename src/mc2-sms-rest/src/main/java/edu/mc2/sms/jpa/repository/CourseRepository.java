package edu.mc2.sms.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.mc2.sms.jpa.entity.Course;

public interface CourseRepository extends CrudRepository<Course,Integer>{
	
	List<Course> findByName(String name);
	
}
