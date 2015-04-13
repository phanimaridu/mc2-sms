package edu.mc2.sms.cntrlr.rest;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.mc2.sms.jpa.model.AttendanceReportDTO;
import edu.mc2.sms.service.AttendanceReportService;

@RestController
@RequestMapping("/attendance_report")
public class AttendanceReportRestController {

	@Autowired
	private AttendanceReportService service;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public AttendanceReportDTO getPerson(HttpServletResponse response,
			@RequestParam(value = "courseScheduleId" , required = true) Integer courseScheduleId) {
		
		return service.getAttendanceReport(courseScheduleId, null, null);
		
	}
	

}