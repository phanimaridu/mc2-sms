package edu.mc2.sms.model;

import java.util.Date;
import java.util.Map;

import edu.mc2.sms.jpa.entity.Attendance;


public class StudentAttendanceReport {

	//map of status and corresponding attendance list
	private Map<Date,Attendance> attendances;
	private CourseScheduleAttendanceStats courseScheduleAttendanceStats;
	
	public Map<Date, Attendance> getAttendances() {
		return attendances;
	}
	public void setAttendances(Map<Date, Attendance> attendances) {
		this.attendances = attendances;
	}
	public CourseScheduleAttendanceStats getCourseScheduleAttendanceStats() {
		return courseScheduleAttendanceStats;
	}
	public void setCourseScheduleAttendanceStats(
			CourseScheduleAttendanceStats courseScheduleAttendanceStats) {
		this.courseScheduleAttendanceStats = courseScheduleAttendanceStats;
	}
	
	
}

