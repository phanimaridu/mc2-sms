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
import edu.mc2.sms.jpa.entity.Staff;
import edu.mc2.sms.jpa.repository.CourseScheduleRepository;
import edu.mc2.sms.jpa.repository.StaffRepository;

//TODO:Move Logics to Service Layer
@RestController
@RequestMapping("/course_schedule")
public class CourseScheduleRestController {

	@Autowired
	private StaffRepository staffRepo;
	
	@Autowired
	private CourseScheduleRepository courseScheduleRepo;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<CourseSchedule> getCourseSchedules(@RequestParam(value = "instructorUserName", required = false) String instructorUserName) {
		return getCourseSchedulesData(instructorUserName);
	}
	
	
	//FIXME:Try to get less data from Database itself
	@RequestMapping(value = "/min", method = RequestMethod.GET)
	public List<CourseSchedule> getCourseSchedulesMinimal(@RequestParam(value = "instructorUserName", required = false) String instructorUserName) {
		return MinimizerUtil.getMinimizedCourseSchedule(getCourseSchedulesData(instructorUserName));
	}
	
	
	public List<CourseSchedule> getCourseSchedulesData(String instructorUserName) {
		List<CourseSchedule> courseSchedules = null;

		if(instructorUserName == null){
			courseSchedules = (List<CourseSchedule>) courseScheduleRepo.findAll();
		}else{
			Staff instructor = staffRepo.findOne(instructorUserName);
			if(instructor != null){
				courseSchedules = instructor.getCourseSchedules();
			}
		}
		
		if (courseSchedules == null || courseSchedules.size() == 0) {
			throw new ResourceNotFoundException("No CourseSchedule Found");
		} else {
			return courseSchedules;
		}
	}
	
	
	
	
	
	
	
}