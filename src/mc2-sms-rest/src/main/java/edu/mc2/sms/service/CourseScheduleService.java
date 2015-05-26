package edu.mc2.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mc2.sms.excepion.ResourceNotFoundException;
import edu.mc2.sms.jpa.entity.CourseSchedule;
import edu.mc2.sms.jpa.entity.Staff;
import edu.mc2.sms.jpa.repository.CourseScheduleRepository;
import edu.mc2.sms.jpa.repository.StaffRepository;

@Service
public class CourseScheduleService {

	
	@Autowired
	private StaffRepository staffRepo;
	
	@Autowired
	private CourseScheduleRepository courseScheduleRepo;
	
	
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
