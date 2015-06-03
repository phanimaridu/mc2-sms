package edu.mc2.sms.jpa.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.mc2.sms.jpa.entity.Attendance;

@Component
@Transactional
public class AttendanceDAO extends HibernateDaoSupport{

	@Autowired
    public void setSessionFactoryAW(SessionFactory sessionFactoryAW){
        super.setSessionFactory(sessionFactoryAW);
    }


	public List<Object[]> getNoOfPresentAttendanceGropByStudent(int courseScheduleId) {

		String qryStr = "SELECT "
				+ "a.studentCourseEnrollment.student,count(a) FROM Attendance a "
				+ "WHERE a.status = 1 AND a.studentCourseEnrollment.courseSchedule.id = :courseScheduleId "
				+ "GROUP BY a.studentCourseEnrollment.student";

		List<Object[]> qryResults = (List<Object[]>) getHibernateTemplate().findByNamedParam(qryStr, 
													new String[]{"courseScheduleId"},  new Object[]{courseScheduleId});

		
		return qryResults;
	}
	
	

	public int getAttendanceCount(int courseScheduleId,Date fromDate, Date toDate){
		//TODO:Change it : Bad Query
		String qryStr = "SELECT "
				+ "count(a) FROM Attendance a "
				+ "WHERE a.studentCourseEnrollment.courseSchedule.id = :courseScheduleId ";
		
		String dateFilter =  "AND a.attendanceBy.takenDtt >= :fromDate AND  a.attendanceBy.takenDtt <= :toDate";
		
		int res = -1;
		
		if(fromDate == null || toDate == null){
		   res = ((List<Long>) getHibernateTemplate().findByNamedParam(qryStr, 
					new String[]{"courseScheduleId"},  
					new Object[]{courseScheduleId})).get(0).intValue();
		}else{
			res = ((List<Long>) getHibernateTemplate().findByNamedParam(qryStr+dateFilter, 
					new String[]{"courseScheduleId","fromDate","toDate"},  
					new Object[]{courseScheduleId,fromDate,toDate})).get(0).intValue();
		}
		
		return res;
	}
	
	
	
	public List<Attendance> getAttendance(int studentCourseEnrollmentId,Date fromDate, Date toDate){
		String qryStr = "SELECT a FROM Attendance a "
				+ "WHERE a.studentCourseEnrollment.id = :studentCourseEnrollmentId ";
		
		String dateFilter =  "AND a.attendanceBy.takenDtt >= :fromDate AND  a.attendanceBy.takenDtt <= :toDate";
		
		List<Attendance> res = null;
		
		if(fromDate == null || toDate == null){
		   res = (List<Attendance>) getHibernateTemplate().findByNamedParam(qryStr, 
					new String[]{"studentCourseEnrollmentId"},  
					new Object[]{studentCourseEnrollmentId});
		}else{
			res = (List<Attendance>) getHibernateTemplate().findByNamedParam(qryStr+dateFilter, 
					new String[]{"studentCourseEnrollmentId","fromDate","toDate"},  
					new Object[]{studentCourseEnrollmentId,fromDate,toDate});
		}
		
		return res;
	}
	
	
	
	public int getPresentAttendanceCount(int courseScheduleId,Date fromDate, Date toDate){

		//TODO:Change it : Bad Query
		String qryStr = "SELECT "
				+ "count(a) FROM Attendance a "
				+ "WHERE a.studentCourseEnrollment.courseSchedule.id = :courseScheduleId "
				+ "AND a.status = 1 ";
	    String dateFilter =  "AND a.attendanceBy.takenDtt >= :fromDate AND  a.attendanceBy.takenDtt <= :toDate";
		
	    int res = -1;
		
		if(fromDate == null || toDate == null){
		   res = ((List<Long>) getHibernateTemplate().findByNamedParam(qryStr, 
					new String[]{"courseScheduleId"},  
					new Object[]{courseScheduleId})).get(0).intValue();
		}else{
			res = ((List<Long>) getHibernateTemplate().findByNamedParam(qryStr+dateFilter, 
					new String[]{"courseScheduleId","fromDate","toDate"},  
					new Object[]{courseScheduleId,fromDate,toDate})).get(0).intValue();
		}
		
		return res;
		
	}
	
	
	
	public int getPresentAttendanceCount(int courseScheduleId,Date takenDtt){

		//TODO:Change it : Bad Query
		String qryStr = "SELECT "
				+ "count(a) FROM Attendance a "
				+ "WHERE a.studentCourseEnrollment.courseSchedule.id = :courseScheduleId "
				+ "AND a.status = 1 "
				+ "AND a.attendanceBy.takenDtt = :takenDtt";
		
		int res = ((List<Long>) getHibernateTemplate().findByNamedParam(qryStr, 
				new String[]{"courseScheduleId","takenDtt"},  
				new Object[]{courseScheduleId,takenDtt})).get(0).intValue();
		
		return res;
	}
	


}
