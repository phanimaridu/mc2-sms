package edu.mc2.sms.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mc2.sms.common.MinimizerUtil;
import edu.mc2.sms.excepion.rest.ResourceNotFoundException;
import edu.mc2.sms.jpa.dao.AttendanceDAO;
import edu.mc2.sms.jpa.entity.Attendance;
import edu.mc2.sms.jpa.entity.CourseSchedule;
import edu.mc2.sms.jpa.entity.Student;
import edu.mc2.sms.jpa.entity.StudentCourseEnrollment;
import edu.mc2.sms.jpa.model.AttendanceReportDTO;
import edu.mc2.sms.jpa.repository.CourseScheduleRepository;

@Service
@Transactional
public class AttendanceReportService {

	@Autowired
	private AttendanceDAO attendanceDAO;

	@Autowired
	private CourseScheduleRepository courseScheduleRepository;
	
	
	public AttendanceReportDTO getAttendanceReport(int courseScheduleId,Date lb,Date ub){
		
		AttendanceReportDTO result = new AttendanceReportDTO();
		
		CourseSchedule courseSchedule = courseScheduleRepository.findOne(courseScheduleId);
		
		if(courseSchedule == null || courseSchedule.getStudentCourseEnrollments() == null 
				|| courseSchedule.getStudentCourseEnrollments().size() == 0){
			throw new ResourceNotFoundException("CourseSchedule Not Found for courseScheduleId : "+courseScheduleId);
		}
		
		//int toatalNoOfClassesPresent = 
		result.setCourseSheduleId(courseScheduleId);
		
		Map<Student, List<Attendance>> attendanceGropByStudent = getAttendanceGropByStudent(courseSchedule);
		Map<Student, Integer> noOfPresentAttendanceGropByStudent = getNoOfPresentAttendanceGropByStudent(courseScheduleId);
		
		//int noOfStudentsForCourseSchedule = noOfPresentAttendanceGropByStudent.keySet().size();
		
		//assuming all students have equal number of attendance mapping
		int totalNoOfClasses = 0;
		if(attendanceGropByStudent.keySet().size() >  0){
			List<Attendance> attenndances = attendanceGropByStudent.get(
					attendanceGropByStudent.keySet().iterator().next());
			if(attenndances != null){
				totalNoOfClasses = attenndances.size();
			}
		}

		
		result.setStudentAttendance(attendanceGropByStudent);
		result.setClassesPresent(noOfPresentAttendanceGropByStudent);
		result.setTotalNoOfClasses(totalNoOfClasses);
		
		return result;
	}
	
	
	private Map<Student, Integer> getNoOfPresentAttendanceGropByStudent(int courseScheduleId) {
		Map<Student, Integer> result = new HashMap<Student, Integer>();
		for(Object[] qryResult : attendanceDAO.getNoOfPresentAttendanceGropByStudent(courseScheduleId)){
			result.put(MinimizerUtil.getMinimizedStudent((Student)qryResult[0]), ((Long)qryResult[1]).intValue());
		}
		return result;
	}
	
	
	
	private Map<Student, List<Attendance>> getAttendanceGropByStudent(CourseSchedule courseSchedule) {
		
		Map<Student, List<Attendance>> result = new HashMap<Student, List<Attendance>>();
		
		//get all course enrollments related to course schedule
		List<StudentCourseEnrollment> studentCourseEnrollments =  courseSchedule.getStudentCourseEnrollments();
		for(StudentCourseEnrollment studentCourseEnrollment : studentCourseEnrollments){
			result.put(MinimizerUtil.getMinimizedStudent(studentCourseEnrollment.getStudent()), 
					MinimizerUtil.getMinimizedAttendances(studentCourseEnrollment.getAttendances()));
		}
		return result;
	}
	
	
	
}
