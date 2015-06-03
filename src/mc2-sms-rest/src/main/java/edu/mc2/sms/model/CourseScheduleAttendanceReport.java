package edu.mc2.sms.model;

import java.util.Date;
import java.util.Map;



public class CourseScheduleAttendanceReport {

	private Map<Date, CourseSchedulePerDayAttendanceReport> attendance;
	private CourseScheduleAttendanceStats courseScheduleAttendanceStats;
	
	public Map<Date, CourseSchedulePerDayAttendanceReport> getAttendance() {
		return attendance;
	}
	public void setAttendance(
			Map<Date, CourseSchedulePerDayAttendanceReport> attendance) {
		this.attendance = attendance;
	}
	public CourseScheduleAttendanceStats getCourseScheduleAttendanceStats() {
		return courseScheduleAttendanceStats;
	}
	public void setCourseScheduleAttendanceStats(
			CourseScheduleAttendanceStats courseScheduleAttendanceStats) {
		this.courseScheduleAttendanceStats = courseScheduleAttendanceStats;
	}
	
}







