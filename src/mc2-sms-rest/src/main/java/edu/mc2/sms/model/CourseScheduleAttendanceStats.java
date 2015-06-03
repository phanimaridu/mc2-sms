package edu.mc2.sms.model;

public class CourseScheduleAttendanceStats {

	private int totalNoOfClasses;
	private int noOfStudents;
	//totalNoOfPresesnts/totalNoOfClasses * Students Enrolled
	private float classAverage;
	
	public CourseScheduleAttendanceStats() {
		super();
	}


	public CourseScheduleAttendanceStats(int totalNoOfClasses,
			int noOfStudents, float classAverage) {
		super();
		this.totalNoOfClasses = totalNoOfClasses;
		this.noOfStudents = noOfStudents;
		this.classAverage = classAverage;
	}
	
	
	public int getTotalNoOfClasses() {
		return totalNoOfClasses;
	}
	public void setTotalNoOfClasses(int totalNoOfClasses) {
		this.totalNoOfClasses = totalNoOfClasses;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	public float getClassAverage() {
		return classAverage;
	}
	public void setClassAverage(float classAverage) {
		this.classAverage = classAverage;
	}
	
	
	
}
