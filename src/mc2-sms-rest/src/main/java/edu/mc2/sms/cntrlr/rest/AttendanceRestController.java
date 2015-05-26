package edu.mc2.sms.cntrlr.rest;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mc2.sms.jpa.entity.Attendance;
import edu.mc2.sms.service.AttendanceService;

//TODO:Write a validator make sure of all courseSchedule Student Attendance is posted
@RestController
@RequestMapping("/attendance")
public class AttendanceRestController {

	@Autowired
	private AttendanceService attendanceService;
	

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public void postAttendance(@RequestBody List<Attendance> attendances,HttpServletResponse response) {
		attendanceService.postAttendance(attendances);
		response.setStatus(HttpStatus.SC_CREATED);
		
	}
	
	

	
	
	
	
	
	
	
	
}