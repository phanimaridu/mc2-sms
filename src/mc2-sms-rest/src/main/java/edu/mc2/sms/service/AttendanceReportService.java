package edu.mc2.sms.service;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mc2.sms.common.MinimizerUtil;
import edu.mc2.sms.excepion.ResourceNotFoundException;
import edu.mc2.sms.jpa.dao.AttendanceByDAO;
import edu.mc2.sms.jpa.dao.AttendanceDAO;
import edu.mc2.sms.jpa.entity.Attendance;
import edu.mc2.sms.jpa.entity.AttendanceBy;
import edu.mc2.sms.jpa.entity.CourseSchedule;
import edu.mc2.sms.jpa.entity.Student;
import edu.mc2.sms.jpa.entity.StudentCourseEnrollment;
import edu.mc2.sms.jpa.repository.AttendanceByRepository;
import edu.mc2.sms.jpa.repository.CourseScheduleRepository;
import edu.mc2.sms.jpa.repository.StudentCourseEnrollmentRepository;
import edu.mc2.sms.model.CourseScheduleAttendanceReport;
import edu.mc2.sms.model.CourseScheduleAttendanceStats;
import edu.mc2.sms.model.CourseSchedulePerDayAttendanceReport;
import edu.mc2.sms.model.StudentAttendanceReport;

//TODO:Write a View and Query all the results at once
@Service

@Transactional
public class AttendanceReportService {

	@Autowired
	private AttendanceDAO attendanceDAO;

	@Autowired
	private AttendanceByDAO attendanceByDAO;
	
	@Autowired
	private AttendanceByRepository attendanceByRepository;
	
	@Autowired
	private CourseScheduleRepository courseScheduleRepository;
	
	@Autowired
	private StudentCourseEnrollmentRepository studentCourseEnrollmentRepository;
	

   	public CourseScheduleAttendanceReport getCourseScheduleAttendanceReport(int courseScheduleId,Date fromDtt,Date toDtt){
    	
   		if(courseScheduleRepository.findOne(courseScheduleId) == null){
   			throw new ResourceNotFoundException("CourseSchedule not found");
   		}
   		
    	CourseScheduleAttendanceReport report = new CourseScheduleAttendanceReport();
    	report.setAttendance(new LinkedHashMap<Date, CourseSchedulePerDayAttendanceReport>());
    	
    	//query attendance by with 3 filters
    	for(AttendanceBy attendanceBy : attendanceByDAO.getAttendanceBys(courseScheduleId, fromDtt, toDtt)){
    		report.getAttendance().put(attendanceBy.getTakenDtt(), 
    				getCourseSchedulePerDayAttendanceReport(courseScheduleId,attendanceBy.getId()));
    	}
    	
    	report.setCourseScheduleAttendanceStats(
    			getCourseScheduleAttendanceStat(courseScheduleId, fromDtt, toDtt));
    	
    	return report;
    }
    


	public StudentAttendanceReport getStudentAttendanceReport(int studentCourseEnrollmentId,Date fromDtt,Date toDtt){
		
		if(studentCourseEnrollmentRepository.findOne(studentCourseEnrollmentId) == null){
   			throw new ResourceNotFoundException("StudentCourseEnrollment not found");
   		}
		
		StudentAttendanceReport report = new StudentAttendanceReport();
		
		report.setCourseScheduleAttendanceStats(
				getCourseScheduleAttendanceStat(studentCourseEnrollmentId, fromDtt, toDtt));
		
		report.setAttendances(new LinkedHashMap<Date, Attendance>());
		
		List<Attendance> attendances = attendanceDAO.getAttendance(studentCourseEnrollmentId, fromDtt, toDtt);
		for(Attendance attendance : attendances){
			report.getAttendances().put(attendance.getAttendanceBy().getTakenDtt(), MinimizerUtil.getMinimizedAttendance(attendance));
		}
		
		return  report;
	}
    
	
	public CourseScheduleAttendanceStats getCourseScheduleAttendanceStats(int courseScheduleId,Date fromDtt,Date toDtt){
    
		if(courseScheduleRepository.findOne(courseScheduleId) == null){
   			throw new ResourceNotFoundException("CourseSchedule not found");
   		}
		
    	return getCourseScheduleAttendanceStat(courseScheduleId,fromDtt,toDtt);
    }
    
   	
	public CourseSchedulePerDayAttendanceReport getCourseSchedulePerDayAttendanceReport(int courseScheduleId, int takenById){
    	
    	CourseSchedulePerDayAttendanceReport report = new CourseSchedulePerDayAttendanceReport();
    	report.setAttendances(new LinkedHashMap<Student, Attendance>());
    	
    	AttendanceBy attendanceBy = attendanceByRepository.findOne(takenById);
    	
    	for(Attendance attendance : attendanceBy.getAttendances()){
    		Student minimizedStudent = MinimizerUtil.getMinimizedStudent(attendance.getStudentCourseEnrollment().getStudent());
    		Attendance minimizedAttendance = MinimizerUtil.getMinimizedAttendance(attendance);
    		report.getAttendances().put(minimizedStudent, minimizedAttendance);
    	}
    	
    	report.setNoOfStudentsPresnet(attendanceDAO
    			.getPresentAttendanceCount(courseScheduleId, attendanceBy.getTakenDtt()));
    	
    	return report;
    }
    
    
	
	private CourseScheduleAttendanceStats getCourseScheduleAttendanceStat(int courseScheduleId,Date fromDtt,Date toDtt){
	
		int noOfStudents = courseScheduleRepository.findOne(courseScheduleId)
				.getStudentCourseEnrollments().size();
		
		int totalNoOfClasses = attendanceByDAO.getTotalNoOfClasses(
				courseScheduleId, fromDtt, toDtt);
		
		float presentPercent = (float)attendanceDAO.getPresentAttendanceCount(courseScheduleId, fromDtt,toDtt)/
				               attendanceDAO.getAttendanceCount(courseScheduleId, fromDtt,toDtt) ;
		
    	return new CourseScheduleAttendanceStats(totalNoOfClasses,noOfStudents,presentPercent*100);
    }
    
	
	
	
	
    public Map<Student, Integer> getNoOfPresentAttendanceGropByStudent(int courseScheduleId) {
		Map<Student, Integer> result = new HashMap<Student, Integer>();
		for(Object[] qryResult : attendanceDAO.getNoOfPresentAttendanceGropByStudent(courseScheduleId)){
			result.put(MinimizerUtil.getMinimizedStudent((Student)qryResult[0]), ((Long)qryResult[1]).intValue());
		}
		return result;
	}
	
	
	
	public Map<Student, List<Attendance>> getAttendanceGropByStudent(CourseSchedule courseSchedule) {
		
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
