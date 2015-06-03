package edu.mc2.sms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mc2.sms.excepion.ConflictException;
import edu.mc2.sms.excepion.ResourceNotFoundException;
import edu.mc2.sms.jpa.dao.AttendanceDAO;
import edu.mc2.sms.jpa.dao.StudentCourseEnrollmentDAO;
import edu.mc2.sms.jpa.entity.Attendance;
import edu.mc2.sms.jpa.entity.AttendanceBy;
import edu.mc2.sms.jpa.entity.Staff;
import edu.mc2.sms.jpa.entity.StudentCourseEnrollment;
import edu.mc2.sms.jpa.repository.AttendanceByRepository;
import edu.mc2.sms.jpa.repository.AttendanceRepository;
import edu.mc2.sms.jpa.repository.StaffRepository;
import edu.mc2.sms.jpa.repository.StudentCourseEnrollmentRepository;
import edu.mc2.sms.util.DateUtil;


@Service
@Transactional
public class AttendanceService {

	@Autowired
	private AttendanceByRepository attendanceByRepository;
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StudentCourseEnrollmentRepository studentCourseEnrollmentRepository;
	
	@Autowired
	private StudentCourseEnrollmentDAO studentCourseEnrollmentDAO;
	
	@Autowired
	private AttendanceDAO attendanceDAO;
	
	
	public void editAttendance(int id, Attendance attendance){
		if (attendanceRepository.findOne(id) == null) {
			throw new ResourceNotFoundException("Attendance Not Found");
		}
		attendance.setId(id);
		attendanceRepository.save(attendance);
	}
	
	
	
	public void postAttendanceMap(Map<Integer,Attendance> attendances) {
		if (attendances == null || attendances.isEmpty()) {
			throw new IllegalArgumentException("Invalid Attendance Data");
		}
		
		Set<Integer> givenStudentCourseEnrollmentIds = attendances.keySet();
		
		//get course schedule id from database
		int studentCourseEnrollmentId = givenStudentCourseEnrollmentIds.iterator().next();
		StudentCourseEnrollment studentCourseEnrollment = studentCourseEnrollmentRepository.findOne(studentCourseEnrollmentId);
		
		if(studentCourseEnrollment == null){
			throw new IllegalArgumentException("No StudentCourseEnrollment Exists with studentCourseEnrollmentId : " 
												+ studentCourseEnrollmentId);
		}
		
		int courseScheduleId = studentCourseEnrollment.getCourseSchedule().getId();
		//check for double submission - Only one submission per course schedule id allowed per day
		//TODO:Bad Query - Try to use AttendanceBy DAO 
		int attendanceCount = attendanceDAO.getAttendanceCount(courseScheduleId,DateUtil.getDate(), DateUtil.getNextDate());
		
		if(attendanceCount > 0){
			throw new ConflictException("Attendance already taken for courseScheduleId : "+courseScheduleId);
		}
		
		
		Set<Integer> registeredStudentCourseEnrollmentIds = studentCourseEnrollmentDAO
												.getStudentCourseEnrollmentIds(courseScheduleId);
		
		//checking if given course enrollments exactly matches registered enrollments
		if(givenStudentCourseEnrollmentIds.size() == registeredStudentCourseEnrollmentIds.size() && 
				givenStudentCourseEnrollmentIds.containsAll(registeredStudentCourseEnrollmentIds)){
			
			Date presentDate = new Date();
			String userName = SecurityContextHolder.getContext().getAuthentication().getName();
			// can never be null because only admin and staff haver permission to  access this resource
			Staff staff = staffRepository.findOne(userName);
			
			AttendanceBy attendanceBy = new AttendanceBy();
			attendanceBy.setStaff(staff);
			attendanceBy.setTakenDtt(presentDate);
			attendanceBy.setAttendances(new ArrayList<Attendance>());
			attendanceBy.setCourseSchedule(studentCourseEnrollment.getCourseSchedule());
			attendanceByRepository.save(attendanceBy);
			
			for (Integer studentCourseEnrollmentIdKey : attendances.keySet()) {
				Attendance attendance = attendances.get(studentCourseEnrollmentIdKey);
				if (attendance != null) {
					
					attendance.setStudentCourseEnrollment(
							studentCourseEnrollmentRepository.findOne(studentCourseEnrollmentIdKey));
					attendance.setAttendanceBy(attendanceBy);
					attendanceBy.getAttendances().add(attendance);
					
				}else{
					throw new IllegalArgumentException("Invalid Attendance Data for studentCourseEnrollmentId : "
								+ studentCourseEnrollmentIdKey);
				}
			}
			//FIXME:don't use attendanceRepository : try to save with attendanceByRepository itself
			attendanceRepository.save(attendanceBy.getAttendances());
			
		}else{
			throw new IllegalArgumentException("Insufficnient or Excess Data : Only Supply Attendance "
					+ "for StudentCourseEnrollment IDs "
					+ registeredStudentCourseEnrollmentIds
					+ " of CourseSchedule ID");
		}
	}
	
	

}
