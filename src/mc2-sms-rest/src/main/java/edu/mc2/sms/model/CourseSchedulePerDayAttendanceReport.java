package edu.mc2.sms.model;

import java.util.Map;

import edu.mc2.sms.jpa.entity.Attendance;
import edu.mc2.sms.jpa.entity.Student;

public class CourseSchedulePerDayAttendanceReport {

	private int noOfStudentsPresnet;
	private Map<Student,Attendance> attendances;
	
	public int getNoOfStudentsPresnet() {
		return noOfStudentsPresnet;
	}
	public void setNoOfStudentsPresnet(int noOfStudentsPresnet) {
		this.noOfStudentsPresnet = noOfStudentsPresnet;
	}
	
	public Map<Student, Attendance> getAttendances() {
		return attendances;
	}
	public void setAttendances(Map<Student, Attendance> attendances) {
		this.attendances = attendances;
	}


	
}
