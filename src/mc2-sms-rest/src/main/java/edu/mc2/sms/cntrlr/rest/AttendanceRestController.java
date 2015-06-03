package edu.mc2.sms.cntrlr.rest;


import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mc2.sms.jpa.entity.Attendance;
import edu.mc2.sms.model.AttendanceDTO;
import edu.mc2.sms.service.AttendanceService;
import edu.mc2.sms.util.DataGeneratorUtil;

@RestController
@RequestMapping("/attendance")
public class AttendanceRestController {

	@Autowired
	private AttendanceService attendanceService;
	
	@RequestMapping(value = "/bulksubmit", method = RequestMethod.GET)
	public AttendanceDTO getSampleData() {
		return DataGeneratorUtil.getAttendanceDTO(null);
	}
	
	@RequestMapping(value = "/bulksubmit", method = RequestMethod.POST)
	public void postAttendanceMap(@RequestBody AttendanceDTO attendanceDTO,HttpServletResponse response) {
		attendanceService.postAttendanceMap(attendanceDTO.getAttendances());
		response.setStatus(HttpStatus.SC_CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void putAttendance(@PathVariable int id,@RequestBody Attendance attendance,HttpServletResponse response){
		attendanceService.editAttendance(id,attendance);
		response.setStatus(HttpStatus.SC_ACCEPTED);
	}
			
	
	
	
}