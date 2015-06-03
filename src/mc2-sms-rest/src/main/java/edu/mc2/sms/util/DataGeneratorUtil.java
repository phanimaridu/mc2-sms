package edu.mc2.sms.util;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import edu.mc2.sms.jpa.entity.Attendance;
import edu.mc2.sms.model.AttendanceDTO;

public class DataGeneratorUtil {

	public static AttendanceDTO getAttendanceDTO(Set<Integer> studentCourseEnrollmentIds){
		
		if(studentCourseEnrollmentIds == null){
			studentCourseEnrollmentIds = new HashSet<Integer>();
			int studentCourseEnrollmentIdArray[] = {34, 1, 4, 37, 7, 43, 40, 10, 46, 13, 16, 49, 19, 55, 52, 22, 25, 28, 31};

			for(int studentCourseEnrollmentIdElement : studentCourseEnrollmentIdArray){
				studentCourseEnrollmentIds.add(studentCourseEnrollmentIdElement);
			}
		}
		
		AttendanceDTO result = new AttendanceDTO();
		
		Map<Integer, Attendance> attendances = new LinkedHashMap<>();
		result.setAttendances(attendances);
		
		for(Integer studentCourseEnrollmentId : studentCourseEnrollmentIds){
			Attendance attendance = new Attendance();
			attendance.setStatus((byte)1);
			attendance.setComment("Present");
			attendances.put(studentCourseEnrollmentId, attendance);
		}
		return result;
	}
}
