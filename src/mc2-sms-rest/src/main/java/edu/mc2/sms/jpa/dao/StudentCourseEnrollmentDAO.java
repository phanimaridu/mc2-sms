package edu.mc2.sms.jpa.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class StudentCourseEnrollmentDAO extends HibernateDaoSupport{

	@Autowired
    public void setSessionFactoryAW(SessionFactory sessionFactoryAW){
        super.setSessionFactory(sessionFactoryAW);
    }


	
	public Set<Integer> getStudentCourseEnrollmentIds(int courseScheduleId) {

		String qryStr = "SELECT "
				+ "distinct(sce.id) FROM StudentCourseEnrollment sce "
				+ "WHERE sce.courseSchedule.id = :courseScheduleId";

		List<Integer> qryResults = (List<Integer>) getHibernateTemplate().findByNamedParam(qryStr, 
													new String[]{"courseScheduleId"},  
													new Object[]{courseScheduleId});
		
		return new HashSet<>(qryResults);
	}
	
	
	


}
