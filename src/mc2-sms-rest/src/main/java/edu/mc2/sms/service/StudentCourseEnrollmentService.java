package edu.mc2.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mc2.sms.excepion.ResourceNotFoundException;
import edu.mc2.sms.jpa.entity.CourseSchedule;
import edu.mc2.sms.jpa.entity.Student;
import edu.mc2.sms.jpa.entity.StudentCourseEnrollment;
import edu.mc2.sms.jpa.repository.CourseScheduleRepository;
import edu.mc2.sms.jpa.repository.StudentCourseEnrollmentRepository;
import edu.mc2.sms.jpa.repository.StudentRepository;

@Service
public class StudentCourseEnrollmentService {

	@Autowired
	private StudentCourseEnrollmentRepository studentCourseEnrollmentRepo;
	
	@Autowired
	private CourseScheduleRepository courseScheduleRepo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	
	public StudentCourseEnrollment getStudentCourseEnrollment(Integer id){
		StudentCourseEnrollment studentCourseEnrollment = studentCourseEnrollmentRepo.findOne(id);
		if(studentCourseEnrollment == null){
			throw new ResourceNotFoundException("StudentCourseEnrollments Not Found");
		}
		return studentCourseEnrollment;
	}
	
	
	public List<StudentCourseEnrollment> getStudentCourseEnrollments(){
		List<StudentCourseEnrollment> studentCourseEnrollments = (List<StudentCourseEnrollment>) studentCourseEnrollmentRepo.findAll();
		if (studentCourseEnrollments == null || studentCourseEnrollments.size() == 0) {
			throw new ResourceNotFoundException("No StudentCourseEnrollments Found");
		} 

		return studentCourseEnrollments;
		
		
	}
			
	public List<StudentCourseEnrollment> getStudentCourseEnrollments(Integer courseScheduleId){
		
		List<StudentCourseEnrollment> studentCourseEnrollments = null;
		CourseSchedule courseSchedule = courseScheduleRepo.findOne(courseScheduleId);
		
		if(courseSchedule == null){
			throw new ResourceNotFoundException("No CourseSchedule Found For Given Course ID : " +courseScheduleId);
		}
		
		studentCourseEnrollments = courseSchedule.getStudentCourseEnrollments();
		if (studentCourseEnrollments == null || studentCourseEnrollments.size() == 0) {
			throw new ResourceNotFoundException("No StudentCourseEnrollments Found For Given Course ID : " +courseScheduleId);
		} 

		return studentCourseEnrollments;
		
	}
	
	
    public List<StudentCourseEnrollment> getStudentCourseEnrollments(String studentUserName){
		
		List<StudentCourseEnrollment> studentCourseEnrollments = null;
		Student student = studentRepo.findOne(studentUserName);
		
		if(student == null){
			throw new ResourceNotFoundException("No Student Found For Given Student UserName  : " +studentUserName);
		}

		studentCourseEnrollments = student.getStudentCourseEnrollments();
		if (studentCourseEnrollments == null || studentCourseEnrollments.size() == 0) {
			throw new ResourceNotFoundException("No StudentCourseEnrollments Found For Given Student UserName  : " +studentUserName);
		} 

		return studentCourseEnrollments;
		
	}


    public void createStudentCourseEnrollment(StudentCourseEnrollment studentCourseEnrollment) {
    	validateStudentCourseEnrollment(studentCourseEnrollment);
    	setValidCourseSchedule(studentCourseEnrollment);
    	setValidCourseStudent(studentCourseEnrollment);
    	studentCourseEnrollmentRepo.save(studentCourseEnrollment);
	}


    public void editStudentCourseEnrollment(int id, StudentCourseEnrollment studentCourseEnrollment) {
    	validateStudentCourseEnrollment(studentCourseEnrollment);
    	if ( studentCourseEnrollmentRepo.findOne(id) == null) {
			throw new ResourceNotFoundException("StudentCourseEnrollment Not Found");
		}
    	studentCourseEnrollment.setId(id);
    	setValidCourseSchedule(studentCourseEnrollment);
    	setValidCourseStudent(studentCourseEnrollment);
    	studentCourseEnrollmentRepo.save(studentCourseEnrollment);
	}
    
    public void deleteStudentCourseEnrollment(int id) {
    	StudentCourseEnrollment sudentCourseEnrollment = studentCourseEnrollmentRepo.findOne(id);
    	if ( sudentCourseEnrollment == null) {
			throw new ResourceNotFoundException("StudentCourseEnrollment Not Found");
		}
    	studentCourseEnrollmentRepo.delete(sudentCourseEnrollment);
    }
    
    
    private void validateStudentCourseEnrollment(StudentCourseEnrollment studentCourseEnrollment){
    	if(studentCourseEnrollment == null || studentCourseEnrollment.getCourseSchedule() == null ||
    			studentCourseEnrollment.getStudent() == null || 
    			studentCourseEnrollment.getStudent().getUserName() == null){
			throw new IllegalArgumentException("Invalid StudentCourseEnrollment Data : Missing Mandatory Fields");
		}
    }
    
    private void setValidCourseSchedule(StudentCourseEnrollment studentCourseEnrollment){
    	CourseSchedule courseSchedule = courseScheduleRepo.findOne(studentCourseEnrollment.getCourseSchedule().getId());
    	if(courseSchedule == null){
    		throw new ResourceNotFoundException("Invalid StudentCourseEnrollment Data : CourseSchedule with given Id not found");
    	}
    	studentCourseEnrollment.setCourseSchedule(courseSchedule);
    }

    
    private void setValidCourseStudent(StudentCourseEnrollment studentCourseEnrollment){
    	Student student = studentRepo.findOne(studentCourseEnrollment.getStudent().getUserName());
    	if(student == null){
    		throw new ResourceNotFoundException("Invalid StudentCourseEnrollment Data : Student with given UserName not found");
    	}
    	studentCourseEnrollment.setStudent(student);
    }
    
   
}
