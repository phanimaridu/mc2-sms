package edu.mc2.sms.jpa.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="academic_year")
	private Date academicYear;

	private Byte credits;

	private String dept;

	private String description;

	private String name;

	//bi-directional many-to-one association to CourseSchedule
	@OneToMany(mappedBy="course")
	@JsonIgnore
	private List<CourseSchedule> courseSchedules;

	public Course() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAcademicYear() {
		return this.academicYear;
	}

	public void setAcademicYear(Date academicYear) {
		this.academicYear = academicYear;
	}

	public Byte getCredits() {
		return this.credits;
	}

	public void setCredits(Byte credits) {
		this.credits = credits;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CourseSchedule> getCourseSchedules() {
		return this.courseSchedules;
	}

	public void setCourseSchedules(List<CourseSchedule> courseSchedules) {
		this.courseSchedules = courseSchedules;
	}

	public CourseSchedule addCourseSchedule(CourseSchedule courseSchedule) {
		getCourseSchedules().add(courseSchedule);
		courseSchedule.setCourse(this);

		return courseSchedule;
	}

	public CourseSchedule removeCourseSchedule(CourseSchedule courseSchedule) {
		getCourseSchedules().remove(courseSchedule);
		courseSchedule.setCourse(null);

		return courseSchedule;
	}

}