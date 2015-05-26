package edu.mc2.sms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mc2.sms.jpa.entity.Attendance;
import edu.mc2.sms.jpa.entity.Staff;
import edu.mc2.sms.jpa.repository.AttendanceRepository;
import edu.mc2.sms.jpa.repository.StaffRepository;


@Service
@Transactional
public class AttendanceService {

	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private StaffRepository staffRepository;


	//FIXME:Double Submission Fix
	//TODO:Check if StudentCourseEnrollment with Other Null values cause any update issues
	public void postAttendance(List<Attendance> attendances) {

		if (attendances == null || attendances.isEmpty()) {
			throw new IllegalArgumentException("Invalid Attendance List Data");
		}

		Date presentDate = new Date();
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		// can never be null because only admin and staff haver permission to  access this resource
		Staff staff = staffRepository.findOne(userName);

		//if anything happens to one record all will be role backed leaving database in consistent state
		for (Attendance attendance : attendances) {
			if (attendance != null && attendance.getStudentCourseEnrollment() != null) {
				attendance.setStaff(staff);
				if (attendance.getTakenDtt() == null) {
					attendance.setTakenDtt(presentDate);
				}
				attendanceRepository.save(attendance);
			}
		}
	}

}
