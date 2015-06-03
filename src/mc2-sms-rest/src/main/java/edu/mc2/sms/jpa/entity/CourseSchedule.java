package edu.mc2.sms.jpa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * The persistent class for the course_schedule database table.
 * 
 */
@Entity
@Table(name="course_schedule")
@NamedQuery(name="CourseSchedule.findAll", query="SELECT c FROM CourseSchedule c")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
public class CourseSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="start_dt")
	private Date startDt;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="end_dt")
	private Date endDt;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
	@Temporal(TemporalType.TIME)
	@Column(name="start_time")
	private Date startTime;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
	@Temporal(TemporalType.TIME)
	@Column(name="end_time")
	private Date endTime;
	
	@Column(name="room_no")
	private String roomNo;
	
	private Byte status;

	private String term;

	@Column(name="future_use")
	private String futureUse;
	
	
	private String notes;
	
	
	//bi-directional many-to-one association to Staff
	@ManyToOne
	@JoinColumn(name="instructor_user_name")
	private Staff staff;

	//bi-directional many-to-one association to Course
	@ManyToOne
	private Course course;

	//bi-directional many-to-one association to StudentCourseEnrollment
	@OneToMany(mappedBy="courseSchedule")
	@JsonIgnore
	private List<StudentCourseEnrollment> studentCourseEnrollments;

	public CourseSchedule() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomNo() {
		return this.roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}
	
	public Date getStartDt() {
		return startDt;
	}

	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	public Date getEndDt() {
		return endDt;
	}

	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}
	
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getFutureUse() {
		return futureUse;
	}

	public void setFutureUse(String futureUse) {
		this.futureUse = futureUse;
	}

	public List<StudentCourseEnrollment> getStudentCourseEnrollments() {
		return this.studentCourseEnrollments;
	}

	public void setStudentCourseEnrollments(List<StudentCourseEnrollment> studentCourseEnrollments) {
		this.studentCourseEnrollments = studentCourseEnrollments;
	}

	public StudentCourseEnrollment addStudentCourseEnrollment(StudentCourseEnrollment studentCourseEnrollment) {
		getStudentCourseEnrollments().add(studentCourseEnrollment);
		studentCourseEnrollment.setCourseSchedule(this);

		return studentCourseEnrollment;
	}

	public StudentCourseEnrollment removeStudentCourseEnrollment(StudentCourseEnrollment studentCourseEnrollment) {
		getStudentCourseEnrollments().remove(studentCourseEnrollment);
		studentCourseEnrollment.setCourseSchedule(null);

		return studentCourseEnrollment;
	}

}