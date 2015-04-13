package edu.mc2.sms.common;

import java.util.ArrayList;
import java.util.List;

import edu.mc2.sms.jpa.entity.Attendance;
import edu.mc2.sms.jpa.entity.Course;
import edu.mc2.sms.jpa.entity.CourseSchedule;
import edu.mc2.sms.jpa.entity.Student;
import edu.mc2.sms.jpa.entity.StudentCourseEnrollment;

//TODO:Replace this code with jakson dynamic inclusion/exclusion strategy
public class MinimizerUtil {


	
	public static List<CourseSchedule> getMinimizedCourseSchedule(List<CourseSchedule> courseSchedules){
		List<CourseSchedule> minimizedResult = null; 
		if(courseSchedules != null){
			minimizedResult = new ArrayList<CourseSchedule>();
			for(CourseSchedule courseSchedule : courseSchedules){
				minimizedResult.add(getMinimizedCourseSchedules(courseSchedule));
			}
		}
		return minimizedResult;
	}
	
	
	public static CourseSchedule getMinimizedCourseSchedules(CourseSchedule courseSchedule){
		
		if(courseSchedule == null) return null;
		
		CourseSchedule minmizedCS = new CourseSchedule();
		
		minmizedCS.setId(courseSchedule.getId());
		
		Course minmizedCourse = new Course();
		minmizedCourse.setId(courseSchedule.getCourse().getId());
		minmizedCourse.setName(courseSchedule.getCourse().getName());
		minmizedCS.setCourse(minmizedCourse);
		
		return minmizedCS;
	}
	
	

	public static  List<StudentCourseEnrollment> getMinimizedStudentCourseEnrollments(List<StudentCourseEnrollment> studentCourseEnrollments){
		List<StudentCourseEnrollment> minimizedResult = null; 
		if(studentCourseEnrollments != null){
			minimizedResult = new ArrayList<StudentCourseEnrollment>();
			for(StudentCourseEnrollment studentCourseEnrollment : studentCourseEnrollments){
				minimizedResult.add(getMinimizedStudentCourseEnrollment(studentCourseEnrollment));
			}
		}
		return minimizedResult;
	}
	
	
	public static  StudentCourseEnrollment getMinimizedStudentCourseEnrollment(StudentCourseEnrollment studentCourseEnrollment){
		StudentCourseEnrollment result = null;
		if(studentCourseEnrollment != null){
			result = new StudentCourseEnrollment();
			
			result.setId(studentCourseEnrollment.getId());
			
			Student enrolledStudent = studentCourseEnrollment.getStudent();
			if(studentCourseEnrollment.getStudent() != null){
				Student resultStudent = new Student();
				
				resultStudent.setUserName(enrolledStudent.getUserName());
				resultStudent.setId(enrolledStudent.getId());
				resultStudent.setFName(enrolledStudent.getFName());
				resultStudent.setMName(enrolledStudent.getMName());
				resultStudent.setLName(enrolledStudent.getLName());
				
				result.setStudent(resultStudent);
			}
		}
		return result;
	}
	
	
	public static  List<Attendance> getMinimizedAttendances(List<Attendance> attendances){
		List<Attendance> minimizedResult = null; 
		if(attendances != null){
			minimizedResult = new ArrayList<Attendance>();
			for(Attendance attendance : attendances){
				minimizedResult.add(getMinimizedAttendance(attendance));
			}
		}
		return minimizedResult;
	}
	
	
	public static  Attendance getMinimizedAttendance(Attendance attendance){
		
		Attendance result = null;
		if(attendance != null){
			result = new Attendance();
			
			/*
			if(attendance.getStudentCourseEnrollment() != null){
				StudentCourseEnrollment sce = new StudentCourseEnrollment();
				sce.setId(attendance.getStudentCourseEnrollment().getId());
				result.setStudentCourseEnrollment(sce);
			}
			
			 */
			
			result.setTakenDtt(attendance.getTakenDtt());
			result.setComment(attendance.getComment());
			result.setStatus(attendance.getStatus());
		}
		return result;
	}
	
	
	
	public static  Student getMinimizedStudent(Student student){
		Student result = null;
		if(student != null){
			result = new Student();
			
			result.setUserName(student.getUserName());
			result.setFName(student.getFName());
			result.setMName(student.getMName());
			result.setLName(student.getLName());
		}
		return result;
	}
	
	
	
}
