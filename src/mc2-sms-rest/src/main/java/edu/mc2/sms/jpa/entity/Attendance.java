package edu.mc2.sms.jpa.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;


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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="taken_dtt")
	private Date takenDtt;

	private Byte status;
	
	//many-to-one association to Staff
	@ManyToOne
	@JoinColumn(name="taken_by")
	private Staff staff;

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

	public Date getTakenDtt() {
		return this.takenDtt;
	}

	public void setTakenDtt(Date takenDtt) {
		this.takenDtt = takenDtt;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public StudentCourseEnrollment getStudentCourseEnrollment() {
		return this.studentCourseEnrollment;
	}

	public void setStudentCourseEnrollment(StudentCourseEnrollment studentCourseEnrollment) {
		this.studentCourseEnrollment = studentCourseEnrollment;
	}

}