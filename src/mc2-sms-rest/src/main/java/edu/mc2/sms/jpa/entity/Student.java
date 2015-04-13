package edu.mc2.sms.jpa.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
@PrimaryKeyJoinColumn(name="user_name")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
public class Student extends Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="future_use")
	private String futureUse;

	private String level;

	@Column(name="parent_email")
	private String parentEmail;

	private Byte status;

	
	//bi-directional many-to-one association to StudentCourseEnrollment
	@OneToMany(mappedBy="student")
	@JsonIgnore
	private List<StudentCourseEnrollment> studentCourseEnrollments;

	public Student() {
	}

	
	public String getFutureUse() {
		return this.futureUse;
	}

	public void setFutureUse(String futureUse) {
		this.futureUse = futureUse;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getParentEmail() {
		return this.parentEmail;
	}

	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}

	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}


	public List<StudentCourseEnrollment> getStudentCourseEnrollments() {
		return this.studentCourseEnrollments;
	}

	public void setStudentCourseEnrollments(List<StudentCourseEnrollment> studentCourseEnrollments) {
		this.studentCourseEnrollments = studentCourseEnrollments;
	}

	public StudentCourseEnrollment addStudentCourseEnrollment(StudentCourseEnrollment studentCourseEnrollment) {
		getStudentCourseEnrollments().add(studentCourseEnrollment);
		studentCourseEnrollment.setStudent(this);

		return studentCourseEnrollment;
	}

	public StudentCourseEnrollment removeStudentCourseEnrollment(StudentCourseEnrollment studentCourseEnrollment) {
		getStudentCourseEnrollments().remove(studentCourseEnrollment);
		studentCourseEnrollment.setStudent(null);

		return studentCourseEnrollment;
	}

	
	
}