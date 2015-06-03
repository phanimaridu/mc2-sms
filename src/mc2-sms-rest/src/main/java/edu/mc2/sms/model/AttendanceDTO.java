package edu.mc2.sms.model;

import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import edu.mc2.sms.jpa.entity.Attendance;
import edu.mc2.sms.json.jackson.ArrayMapDeserializer;


public class AttendanceDTO {

	@JsonDeserialize(using = ArrayMapDeserializer.class)
	private Map<Integer,Attendance> attendances;

	public Map<Integer, Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(Map<Integer, Attendance> attendances) {
		this.attendances = attendances;
	}

	
}

