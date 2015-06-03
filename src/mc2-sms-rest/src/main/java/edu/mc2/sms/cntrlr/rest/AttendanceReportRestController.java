package edu.mc2.sms.cntrlr.rest;


import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

import edu.mc2.sms.model.CourseScheduleAttendanceReport;
import edu.mc2.sms.model.CourseScheduleAttendanceStats;
import edu.mc2.sms.model.StudentAttendanceReport;
import edu.mc2.sms.service.AttendanceReportService;

@RestController
@RequestMapping("/attendance_report")
@Api(basePath = "/attendance_report", value = "AttendanceReport", description = "Use 'yyyy-MM-dd HH:mm:ss' Pattern for Dates")
public class AttendanceReportRestController {

	@Autowired
	private AttendanceReportService service;
	
	
	@RequestMapping(value = "/course_schedule", method = RequestMethod.GET)
	public CourseScheduleAttendanceReport getCourseScheduleAttendanceReport(HttpServletResponse response,
			@RequestParam(value = "courseScheduleId" , required = true) Integer courseScheduleId,
			@RequestParam(value = "fromDtt" , required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fromDtt,
			@RequestParam(value = "toDtt" , required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date toDtt) {
		
		return service.getCourseScheduleAttendanceReport(courseScheduleId, fromDtt, toDtt);
	}


	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public StudentAttendanceReport getStudentAttendanceReport(HttpServletResponse response,
			@RequestParam(value = "studentCourseEnrollmentId" , required = true) Integer studentCourseEnrollmentId,
			@RequestParam(value = "fromDtt" , required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fromDtt,
			@RequestParam(value = "toDtt" , required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date toDtt) {
		
		return service.getStudentAttendanceReport(studentCourseEnrollmentId, fromDtt, toDtt);
	}
	
	//public CourseScheduleAttendanceStats getCourseScheduleAttendanceStats(int courseScheduleId,Date fromDtt,Date toDtt){
	@RequestMapping(value = "/course_schedule_stats", method = RequestMethod.GET)
	public CourseScheduleAttendanceStats getCourseScheduleAttendanceStats(HttpServletResponse response,
			@RequestParam(value = "courseScheduleId" , required = true) Integer courseScheduleId,
			@RequestParam(value = "fromDtt" , required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fromDtt,
			@RequestParam(value = "toDtt" , required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date toDtt) {
		
		return service.getCourseScheduleAttendanceStats(courseScheduleId, fromDtt, toDtt);
	}
	
	
	
	
	
	
	
}