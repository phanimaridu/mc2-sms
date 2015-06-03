package edu.mc2.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mc2.sms.excepion.ConflictException;
import edu.mc2.sms.excepion.ResourceNotFoundException;
import edu.mc2.sms.jpa.entity.Course;
import edu.mc2.sms.jpa.repository.CourseRepository;

@Service
@Transactional
public class CourseService {

	@Autowired
	private CourseRepository repo;
	

	public List<Course> getCourses() {
		List<Course> courses = (List<Course>) repo.findAll();
		if (courses == null || courses.size() == 0) {
			throw new ResourceNotFoundException("No Course Found");
		} else {
			return courses;
		}
	}
	
	public List<Course> getCourses(String name) {
		List<Course> courses = (List<Course>) repo.findByName(name);
		if (courses == null || courses.size() == 0) {
			throw new ResourceNotFoundException("No Course Found");
		} else {
			return courses;
		}
	}
	
	
	public Course getCourse(int id) {
		Course course = repo.findOne(id);
		if (course == null ) {
			throw new ResourceNotFoundException("No Course Found");
		} else {
			return course;
		}
	}

	
	public void createCourse(Course course) {
		
		if(course == null ){
			throw new IllegalArgumentException("Invalid Course Data");
		}
		
		if (repo.findOne(course.getId()) != null) {
			throw new ConflictException("Course Already Exists");
		}
		repo.save(course);
	}

	
	
	public void editCourse(int id, Course course) {
		if(course == null ){
			throw new IllegalArgumentException("Invalid Course Data");
		}
		
		if (repo.findOne(id) == null) {
			throw new ResourceNotFoundException("Course Not Found");
		}
		course.setId(id);
		repo.save(course);
	}
	
	
	
	public void deleteCourse(int id) {
		Course course = repo.findOne(id);
		if (course == null) {
			throw new ResourceNotFoundException("Course not found");
		} else {
			repo.delete(course);
		}
	}
	
	
}
