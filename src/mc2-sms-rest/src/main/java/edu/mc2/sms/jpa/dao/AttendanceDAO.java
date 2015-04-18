package edu.mc2.sms.jpa.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AttendanceDAO extends HibernateDaoSupport{

	@Autowired
    public void setSessionFactoryAW(SessionFactory sessionFactoryAW){
        super.setSessionFactory(sessionFactoryAW);
    }


	@Transactional
	public List<Object[]> getNoOfPresentAttendanceGropByStudent(int courseScheduleId) {

		String qryStr = "SELECT "
				+ "a.studentCourseEnrollment.student,count(a) FROM Attendance a "
				+ "WHERE a.status = 1 AND a.studentCourseEnrollment.courseSchedule.id = :courseScheduleId "
				+ "GROUP BY a.studentCourseEnrollment.student";

		List<Object[]> qryResults = (List<Object[]>) getHibernateTemplate().findByNamedParam(qryStr, 
													new String[]{"courseScheduleId"},  new Object[]{courseScheduleId});

		
		
		return qryResults;
	}
	


}
