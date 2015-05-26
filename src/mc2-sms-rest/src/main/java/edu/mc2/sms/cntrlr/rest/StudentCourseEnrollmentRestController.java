package edu.mc2.sms.cntrlr.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.mc2.sms.common.MinimizerUtil;
import edu.mc2.sms.jpa.entity.StudentCourseEnrollment;
import edu.mc2.sms.service.StudentCourseEnrollmentService;

@RestController
@RequestMapping("/student_course_enrollment")
public class StudentCourseEnrollmentRestController {

	@Autowired
	private StudentCourseEnrollmentService studentCourseEnrollmentService;
	

	@RequestMapping(value = "/min", method = RequestMethod.GET)
	public List<StudentCourseEnrollment> getStudentCourseEnrollmentsMinimal(
			@RequestParam(value = "courseScheduleId" , required = true) Integer courseScheduleId ) {	
		
		return MinimizerUtil.getMinimizedStudentCourseEnrollments(
				studentCourseEnrollmentService.geStudentCourseEnrollmentsData(courseScheduleId));
	}
	
}