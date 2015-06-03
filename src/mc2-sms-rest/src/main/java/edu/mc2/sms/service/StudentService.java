package edu.mc2.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mc2.sms.excepion.ConflictException;
import edu.mc2.sms.excepion.ResourceNotFoundException;
import edu.mc2.sms.jpa.entity.Student;
import edu.mc2.sms.jpa.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository repo;
	

	public List<Student> getStudents() {
		List<Student> students = (List<Student>) repo.findAll();
		if (students == null || students.size() == 0) {
			throw new ResourceNotFoundException("No Student Found");
		} else {
			return students;
		}
	}
	
	
	public Student getStudent(String userName) {
		Student student = repo.findOne(userName);
		if (student == null ) {
			throw new ResourceNotFoundException("No Student Found");
		} else {
			return student;
		}
	}

	
	public void createStudent(Student student) {
		
		if(student == null || student.getUserName() == null || student.getUserName().isEmpty() ||
				student.getPassword() == null|| student.getPassword().isEmpty()){
			throw new IllegalArgumentException("Invalid Student Data");
		}
		
		if (repo.findOne(student.getUserName()) != null) {
			throw new ConflictException("User Already Exists");
		}
		student.setPassword(new BCryptPasswordEncoder().encode(student.getPassword()));
		repo.save(student);
	}

	
	
	public void editStudent(String userName, Student student) {
		if(student == null || student.getUserName() == null || student.getUserName().isEmpty() ||
				student.getPassword() == null|| student.getPassword().isEmpty()){
			throw new IllegalArgumentException("Invalid Student Data");
		}
		
		if (repo.findOne(userName) == null) {
			throw new ResourceNotFoundException("Student Not Found");
		}
		student.setUserName(userName);
		// encode password to BCrypt hash
		student.setPassword(new BCryptPasswordEncoder().encode(student.getPassword()));
		repo.save(student);
	}
	
	
	
	public void deleteStudent(String userName) {
		Student student = repo.findOne(userName);
		if (student == null) {
			throw new ResourceNotFoundException("Student not found");
		} else {
			repo.delete(student);
		}
	}
	
	
}
