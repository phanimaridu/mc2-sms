package edu.mc2.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mc2.sms.excepion.ResourceNotFoundException;
import edu.mc2.sms.jpa.entity.Course;
import edu.mc2.sms.jpa.entity.CourseSchedule;
import edu.mc2.sms.jpa.entity.Staff;
import edu.mc2.sms.jpa.repository.CourseRepository;
import edu.mc2.sms.jpa.repository.CourseScheduleRepository;
import edu.mc2.sms.jpa.repository.StaffRepository;

@Service
public class CourseScheduleService {

	
	@Autowired
	private StaffRepository staffRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private CourseScheduleRepository courseScheduleRepo;
	
	
	public CourseSchedule getCourseSchedule(int id) {
		CourseSchedule courseSchedule = courseScheduleRepo.findOne(id);
		if (courseSchedule == null ) {
			throw new ResourceNotFoundException("CourseSchedule Not Found");
		}
		return courseSchedule;
	}
	
	
	public List<CourseSchedule> getCourseSchedulesData() {
		List<CourseSchedule> courseSchedules = (List<CourseSchedule>) courseScheduleRepo.findAll();
		if (courseSchedules == null || courseSchedules.size() == 0) {
			throw new ResourceNotFoundException("No CourseSchedule Found");
		} else {
			return courseSchedules;
		}
	}
	
	public List<CourseSchedule> getCourseSchedulesData(String instructorUserName) {
		List<CourseSchedule> courseSchedules = null;

		Staff instructor = staffRepo.findOne(instructorUserName);
		if(instructor != null){
			courseSchedules = instructor.getCourseSchedules();
		}
		
		if (courseSchedules == null || courseSchedules.size() == 0) {
			throw new ResourceNotFoundException("No CourseSchedule Found");
		} else {
			return courseSchedules;
		}
	}
	
	
	
    public void createCourseSchedule(CourseSchedule courseSchedule) {
    	validCourseSchedule(courseSchedule);
    	setValidCourse(courseSchedule);
    	setValidInstructor(courseSchedule);
    	courseScheduleRepo.save(courseSchedule);
	}
    
    
    public void editCourseSchedule(int id, CourseSchedule courseSchedule) {
    	validCourseSchedule(courseSchedule);
    	if ( courseScheduleRepo.findOne(id) == null) {
			throw new ResourceNotFoundException("CourseSchedule Not Found");
		}
    	courseSchedule.setId(id);
    	setValidCourse(courseSchedule);
    	setValidInstructor(courseSchedule);
    	courseScheduleRepo.save(courseSchedule);
	}
    
    public void deleteCourseSchedule(int id) {
    	CourseSchedule courseSchedule = courseScheduleRepo.findOne(id);
    	if ( courseSchedule == null) {
			throw new ResourceNotFoundException("CourseSchedule Not Found");
		}
    	courseScheduleRepo.delete(courseSchedule);
    }
    
    
    private void validCourseSchedule(CourseSchedule courseSchedule){
    	if(courseSchedule == null || courseSchedule.getCourse() == null ||
    			courseSchedule.getStaff() == null || 
    			courseSchedule.getStaff().getUserName() == null){
			throw new IllegalArgumentException("Invalid CourseSchedule Data : Missing Mandatory Fields");
		}
    }
    
    private void setValidInstructor(CourseSchedule courseSchedule){

    	Staff instuctor = staffRepo.findOne(courseSchedule.getStaff().getUserName());
    	if(instuctor == null){
    		throw new ResourceNotFoundException("Invalid CourseSchedule Data : Staff with given UserName not found");
    	}
    
    	courseSchedule.setStaff(instuctor);
    	
    }

    
    private void setValidCourse(CourseSchedule courseSchedule){
    	
    	Course course = courseRepo.findOne(courseSchedule.getCourse().getId());
    	if(course == null){
    		throw new ResourceNotFoundException("Invalid CourseSchedule Data : Course with given ID not found");
    	}
    	
    	courseSchedule.setCourse(course);
    }
}
