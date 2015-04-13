package edu.mc2.sms.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mc2.sms.jpa.entity.StudentCourseEnrollment;

public interface StudentCourseEnrollmentRepository extends CrudRepository<StudentCourseEnrollment,Integer>{
	
}
