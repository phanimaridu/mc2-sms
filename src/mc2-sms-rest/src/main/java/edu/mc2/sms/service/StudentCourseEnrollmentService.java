package edu.mc2.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mc2.sms.excepion.ResourceNotFoundException;
import edu.mc2.sms.jpa.entity.CourseSchedule;
import edu.mc2.sms.jpa.entity.StudentCourseEnrollment;
import edu.mc2.sms.jpa.repository.CourseScheduleRepository;
import edu.mc2.sms.jpa.repository.StudentCourseEnrollmentRepository;

@Service
public class StudentCourseEnrollmentService {

	@Autowired
	private StudentCourseEnrollmentRepository studentCourseEnrollmentRepo;
	
	@Autowired
	private CourseScheduleRepository courseScheduleRepo;
	
	
	public List<StudentCourseEnrollment> geStudentCourseEnrollmentsData(Integer courseScheduleId){
		
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
