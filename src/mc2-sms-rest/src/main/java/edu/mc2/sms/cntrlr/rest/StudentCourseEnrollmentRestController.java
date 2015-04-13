package edu.mc2.sms.cntrlr.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.mc2.sms.common.MinimizerUtil;
import edu.mc2.sms.excepion.rest.ResourceNotFoundException;
import edu.mc2.sms.jpa.entity.CourseSchedule;
import edu.mc2.sms.jpa.entity.StudentCourseEnrollment;
import edu.mc2.sms.jpa.repository.CourseScheduleRepository;
import edu.mc2.sms.jpa.repository.StudentCourseEnrollmentRepository;

//TODO:Move Logics to Service Layer
@RestController
@RequestMapping("/student_course_enrollment")
public class StudentCourseEnrollmentRestController {

	@Autowired
	private StudentCourseEnrollmentRepository studentCourseEnrollmentRepo;
	
	@Autowired
	private CourseScheduleRepository courseScheduleRepo;

	
	@RequestMapping(value = "/min", method = RequestMethod.GET)
	public List<StudentCourseEnrollment> getStudentCourseEnrollmentsMinimal(
			@RequestParam(value = "courseScheduleId" , required = true) Integer courseScheduleId ) {	
		return MinimizerUtil.getMinimizedStudentCourseEnrollments(geStudentCourseEnrollmentsData(courseScheduleId));
	}
	
	private List<StudentCourseEnrollment> geStudentCourseEnrollmentsData(Integer courseScheduleId){
		
		List<StudentCourseEnrollment> studentCourseEnrollments = null;
		CourseSchedule courseSchedule = courseScheduleRepo.findOne(courseScheduleId);
		if(courseSchedule != null){
			studentCourseEnrollments = courseSchedule.getStudentCourseEnrollments();
		}
		
		if (studentCourseEnrollments == null || studentCourseEnrollments.size() == 0) {
			throw new ResourceNotFoundException("No StudentCourseEnrollments Found For Given Course ID : " +courseScheduleId);
		} else {
			return studentCourseEnrollments;
		}
	}
	

	


}