package edu.mc2.sms.jpa.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.mc2.sms.jpa.entity.AttendanceBy;

@Component
@Transactional
public class AttendanceByDAO extends HibernateDaoSupport{

	@Autowired
    public void setSessionFactoryAW(SessionFactory sessionFactoryAW){
        super.setSessionFactory(sessionFactoryAW);
    }


	public List<AttendanceBy> getAttendanceBys(int courseScheduleId,Date fromDtt, Date toDtt) {
		String qryStr = "SELECT a FROM AttendanceBy a WHERE a.courseSchedule.id = :courseScheduleId ";
		String dateFilter =  " AND a.takenDtt >= :fromDtt AND a.takenDtt <= :toDtt ";

		List<AttendanceBy> qryResults = null;
		
		if(fromDtt == null || toDtt == null){
			qryResults = (List<AttendanceBy>) getHibernateTemplate().findByNamedParam(qryStr, 
					new String[]{"courseScheduleId"},  new Object[]{courseScheduleId});
		}else{
			qryResults = (List<AttendanceBy>) getHibernateTemplate().findByNamedParam(qryStr + dateFilter, 
					new String[]{"courseScheduleId","fromDtt","toDtt"}, 
					new Object[]{courseScheduleId,fromDtt,toDtt});
		}
		return qryResults;
	}


	public int getTotalNoOfClasses(int courseScheduleId,Date fromDtt, Date toDtt) {
		String qryStr = "SELECT count(a) FROM AttendanceBy a WHERE a.courseSchedule.id = :courseScheduleId ";
		String dateFilter =  " AND a.takenDtt >= :fromDtt AND a.takenDtt <= :toDtt ";

		int  qryResult = -1;
		
		if(fromDtt == null || toDtt == null){
			qryResult = ((List<Long>) getHibernateTemplate().findByNamedParam(qryStr, 
					new String[]{"courseScheduleId"},  new Object[]{courseScheduleId})).get(0).intValue();
		}else{
			qryResult = ((List<Long>) getHibernateTemplate().findByNamedParam(qryStr + dateFilter, 
					new String[]{"courseScheduleId","fromDtt","toDtt"}, 
					new Object[]{courseScheduleId,fromDtt,toDtt})).get(0).intValue();
		}
		return qryResult;
	}

	


}
