package edu.mc2.sms.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mc2.sms.jpa.entity.Student;

public interface StudentRepository extends CrudRepository<Student,String>{

	
}
