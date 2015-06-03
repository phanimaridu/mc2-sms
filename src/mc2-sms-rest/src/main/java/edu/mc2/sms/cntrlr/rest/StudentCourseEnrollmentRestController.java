package edu.mc2.sms.cntrlr.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.mc2.sms.common.MinimizerUtil;
import edu.mc2.sms.jpa.entity.StudentCourseEnrollment;
import edu.mc2.sms.service.StudentCourseEnrollmentService;

@RestController
@RequestMapping("/student_course_enrollment")
public class StudentCourseEnrollmentRestController {

	@Autowired
	private StudentCourseEnrollmentService service;
	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public StudentCourseEnrollment getStudentCourseEnrollment(@PathVariable int id) {
		return service.getStudentCourseEnrollment(id);
	}

	@RequestMapping(value = "/min/{id}", method = RequestMethod.GET)
	public StudentCourseEnrollment getStudentCourseEnrollmentMinimal(@PathVariable int id) {
		return MinimizerUtil.getMinimizedStudentCourseEnrollment(
				service.getStudentCourseEnrollment(id));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<StudentCourseEnrollment> getStudentCourseEnrollments(
			@RequestParam(value = "studentUserName", required = false) String studentUserName,
			@RequestParam(value = "courseScheduleId", required = false) Integer courseScheduleId) {
		if(studentUserName == null && courseScheduleId == null){
			return service.getStudentCourseEnrollments();
		}else if (studentUserName != null){
			return service.getStudentCourseEnrollments(studentUserName);
		}else if(courseScheduleId != null){
			return service.getStudentCourseEnrollments(courseScheduleId);
		}else{
			//FIXME:Apply Double Filter
			return service.getStudentCourseEnrollments(courseScheduleId);
		}
	}

	@RequestMapping(value = "/min", method = RequestMethod.GET)
	public List<StudentCourseEnrollment> getStudentCourseEnrollmentsMinimal(
			@RequestParam(value = "studentUserName", required = false) String studentUserName,
			@RequestParam(value = "courseScheduleId", required = false) Integer courseScheduleId) {
		
		List<StudentCourseEnrollment> result = null;
		if(studentUserName == null && courseScheduleId == null){
			result =  service.getStudentCourseEnrollments();
		}else if (studentUserName != null){
			result =  service.getStudentCourseEnrollments(studentUserName);
		}else if(courseScheduleId != null){
			result =  service.getStudentCourseEnrollments(courseScheduleId);
		}else{
			//FIXME:Apply Double Filter
			result =  service.getStudentCourseEnrollments(courseScheduleId);
		}
		return MinimizerUtil.getMinimizedStudentCourseEnrollments(result);
	}
	

	@RequestMapping(method = RequestMethod.POST)
	public void create(@RequestBody StudentCourseEnrollment studentCourseEnrollment, 
			UriComponentsBuilder uriBuilder,HttpServletResponse response) {
		service.createStudentCourseEnrollment(studentCourseEnrollment);
		response.setStatus(HttpStatus.SC_CREATED);
		response.setHeader("Location", uriBuilder.path("/student_course_enrollment/{id}")
				.buildAndExpand(studentCourseEnrollment.getId()).toUriString());
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void edit(@PathVariable int id,@RequestBody StudentCourseEnrollment studentCourseEnrollment, 
			HttpServletResponse response) {
		service.editStudentCourseEnrollment(id,studentCourseEnrollment);
		response.setStatus(HttpStatus.SC_OK);
	}
	
	//delete
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void edit(@PathVariable int id,HttpServletResponse response) {
		service.deleteStudentCourseEnrollment(id);
		response.setStatus(HttpStatus.SC_OK);
	}
	
	

}