package edu.mc2.sms.jpa.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;


/**
 * The persistent class for the school_schedule database table.
 * 
 */
@Entity
@Table(name="school_schedule")
@NamedQuery(name="SchoolSchedule.findAll", query="SELECT s FROM SchoolSchedule s")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
public class SchoolSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="annonced_by")
	private String annoncedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_dtt")
	private Date endDtt;

	@Column(name="event_name")
	private String eventName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_dtt")
	private Date startDtt;

	private Byte status;

	public SchoolSchedule() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnnoncedBy() {
		return this.annoncedBy;
	}

	public void setAnnoncedBy(String annoncedBy) {
		this.annoncedBy = annoncedBy;
	}

	public Date getEndDtt() {
		return this.endDtt;
	}

	public void setEndDtt(Date endDtt) {
		this.endDtt = endDtt;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getStartDtt() {
		return this.startDtt;
	}

	public void setStartDtt(Date startDtt) {
		this.startDtt = startDtt;
	}

	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

}