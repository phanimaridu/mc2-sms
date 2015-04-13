package edu.mc2.sms.jpa.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;


/**
 * The persistent class for the staff database table.
 * 
 */
@Entity
@NamedQuery(name="Staff.findAll", query="SELECT s FROM Staff s")
@PrimaryKeyJoinColumn(name="user_name")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
public class Staff extends Person implements Serializable {
	private static final long serialVersionUID = 1L;

	private String designation;

	@Column(name="future_use")
	private String futureUse;

	private String notes;

	private Byte status;

	//bi-directional many-to-one association to CourseSchedule
	@OneToMany(mappedBy="staff")
	@JsonIgnore
	private List<CourseSchedule> courseSchedules;


	public Staff() {
	}

	
	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getFutureUse() {
		return this.futureUse;
	}

	public void setFutureUse(String futureUse) {
		this.futureUse = futureUse;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public List<CourseSchedule> getCourseSchedules() {
		return this.courseSchedules;
	}

	public void setCourseSchedules(List<CourseSchedule> courseSchedules) {
		this.courseSchedules = courseSchedules;
	}

	public CourseSchedule addCourseSchedule(CourseSchedule courseSchedule) {
		getCourseSchedules().add(courseSchedule);
		courseSchedule.setStaff(this);

		return courseSchedule;
	}

	public CourseSchedule removeCourseSchedule(CourseSchedule courseSchedule) {
		getCourseSchedules().remove(courseSchedule);
		courseSchedule.setStaff(null);

		return courseSchedule;
	}


}