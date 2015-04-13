package edu.mc2.sms.jpa.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import edu.mc2.sms.jpa.entity.Attendance;
import edu.mc2.sms.jpa.entity.Student;

//if a student requires this result then add only one entry in studentAttendance
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
public class AttendanceReportDTO {
	
	private int courseSheduleId;
	private Date fromDtt;
	private Date toDtt;
	
	private int totalNoOfClasses;
	private float classAverage;
	
	private Map<Student, List<Attendance>> studentAttendance;
	private Map<Student, Integer> classesPresent;
	
	public int getCourseSheduleId() {
		return courseSheduleId;
	}
	public void setCourseSheduleId(int courseSheduleId) {
		this.courseSheduleId = courseSheduleId;
	}
	public Date getFromDtt() {
		return fromDtt;
	}
	public void setFromDtt(Date fromDtt) {
		this.fromDtt = fromDtt;
	}
	public Date getToDtt() {
		return toDtt;
	}
	public void setToDtt(Date toDtt) {
		this.toDtt = toDtt;
	}
	public int getTotalNoOfClasses() {
		return totalNoOfClasses;
	}
	public void setTotalNoOfClasses(int totalNoOfClasses) {
		this.totalNoOfClasses = totalNoOfClasses;
	}
	public float getClassAverage() {
		return classAverage;
	}
	public void setClassAverage(float classAverage) {
		this.classAverage = classAverage;
	}
	public Map<Student, List<Attendance>> getStudentAttendance() {
		return studentAttendance;
	}
	public void setStudentAttendance(
			Map<Student, List<Attendance>> studentAttendance) {
		this.studentAttendance = studentAttendance;
	}
	
	public Map<Student, Integer> getClassesPresent() {
		return classesPresent;
	}
	public void setClassesPresent(Map<Student, Integer> classesPresent) {
		this.classesPresent = classesPresent;
	}


	

	
	
}

