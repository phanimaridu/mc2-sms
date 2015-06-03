package edu.mc2.sms.jpa.entity;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@NamedQuery(name="AttendanceBy.findAll", query="SELECT a FROM AttendanceBy a")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
public class AttendanceBy {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="taken_dtt")
	private Date takenDtt;
	
	//many-to-one association to Staff
	@ManyToOne
	@JoinColumn(name="taken_by")
	private Staff staff;
	
	//bi-directional many-to-one association to Attendance
	@OneToMany(mappedBy="attendanceBy")
	private List<Attendance> attendances;
	
	@ManyToOne
	@JoinColumn(name="course_schedule_id")
	private CourseSchedule courseSchedule;

	public AttendanceBy() { }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	public CourseSchedule getCourseSchedule() {
		return courseSchedule;
	}

	public void setCourseSchedule(CourseSchedule courseSchedule) {
		this.courseSchedule = courseSchedule;
	}

	
}
