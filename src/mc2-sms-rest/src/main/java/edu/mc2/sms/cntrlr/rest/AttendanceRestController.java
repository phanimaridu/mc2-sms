package edu.mc2.sms.cntrlr.rest;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mc2.sms.excepion.rest.BadRequestException;
import edu.mc2.sms.excepion.rest.InternalServerError;
import edu.mc2.sms.jpa.entity.Attendance;
import edu.mc2.sms.jpa.entity.Staff;
import edu.mc2.sms.jpa.repository.AttendanceRepository;
import edu.mc2.sms.jpa.repository.StaffRepository;

//TODO:Move Logics to Service Layer
//TODO:Write a validator make sure of all courseSchedule Student Attendance is posted
@RestController
@RequestMapping("/attendance")
public class AttendanceRestController {

	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private StaffRepository staffRepository;

	
	//FIXME:Double Submission Fix
	//TODO:Check if StudentCourseEnrollment with Other Null values cause any update issues
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public void postAttendance(@RequestBody List<Attendance> attendances,HttpServletResponse response) {
		
		if(attendances == null || attendances.isEmpty()){
			throw new BadRequestException("Invalid Attendance List Data");
		}
		
		StringBuilder excecptonSB = new StringBuilder();
		// 0 - based index
		int recordIndex = 0;
		Date presentDate = new Date();
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		//can never be null because only admin and staff haver permission to access this resource
		Staff staff = staffRepository.findOne(userName);
		
		
		for(Attendance attendance : attendances){

			if(attendance != null && attendance.getStudentCourseEnrollment() != null){
				
				try{
					attendance.setStaff(staff);
					if(attendance.getTakenDtt() == null){
						attendance.setTakenDtt(presentDate);
					}
					
					attendanceRepository.save(attendance);
					
				}catch(Exception e){
					excecptonSB.append("Exception While Recording Attendance Data RECORD NO [")
								.append(recordIndex).append("] : ").append(e.getMessage()).append("\n");
				}
				
			}else{
				excecptonSB.append("Invalid Attendance Data RECORD NO ["+ recordIndex +"]\n");
			}
			
			recordIndex ++;
		}
		
		
		if(!excecptonSB.toString().isEmpty()){
			throw new InternalServerError(excecptonSB.toString());
		}else{
			response.setStatus(HttpStatus.SC_CREATED);
		}
		
	}
	
	

	
	
	
	
	
	
	
}