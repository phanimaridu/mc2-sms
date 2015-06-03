package edu.mc2.sms.cntrlr.rest;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.mc2.sms.jpa.entity.Student;
import edu.mc2.sms.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	@Autowired
	private StudentService studentService;
	

	@RequestMapping(method = RequestMethod.GET)
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	
	
	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable String userName) {
		return studentService.getStudent(userName);
	}

	
	
	@RequestMapping(method = RequestMethod.POST)
	public void createStudent(@RequestBody Student student, UriComponentsBuilder uriBuilder,HttpServletResponse response) {
		studentService.createStudent(student);
		response.setStatus(HttpStatus.SC_CREATED);
		response.setHeader("Location", uriBuilder.path("/student/{userName}")
				.buildAndExpand(student.getUserName()).toUriString());
			
	}
	
	
	
	@RequestMapping(value = "/{userName}",method = RequestMethod.PUT)
	public void editStudent(@PathVariable String userName,@RequestBody Student student, HttpServletResponse response) {
		studentService.editStudent(userName, student);
	    response.setStatus(HttpStatus.SC_ACCEPTED);
	}
	
	
	
	@RequestMapping(value = "/{userName}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable String userName,HttpServletResponse response) {
		studentService.deleteStudent(userName);
		response.setStatus(HttpStatus.SC_OK);
	}
	
	
}