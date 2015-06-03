package edu.mc2.sms.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * The persistent class for the attendance database table.
 * 
 */
@Entity
@NamedQuery(name="Attendance.findAll", query="SELECT a FROM Attendance a")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
public class Attendance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String comment;

	private Byte status;
	
	//bi-directional many-to-one association to AttendanceBy
	@ManyToOne
	@JoinColumn(name="taken_by")
	private AttendanceBy attendanceBy;

	//bi-directional many-to-one association to StudentCourseEnrollment
	@ManyToOne
	@JoinColumn(name="student_course_enrollment_id")
	private StudentCourseEnrollment studentCourseEnrollment;

	public Attendance() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public AttendanceBy getAttendanceBy() {
		return attendanceBy;
	}

	public void setAttendanceBy(AttendanceBy attendanceBy) {
		this.attendanceBy = attendanceBy;
	}

	public StudentCourseEnrollment getStudentCourseEnrollment() {
		return this.studentCourseEnrollment;
	}

	public void setStudentCourseEnrollment(StudentCourseEnrollment studentCourseEnrollment) {
		this.studentCourseEnrollment = studentCourseEnrollment;
	}

}