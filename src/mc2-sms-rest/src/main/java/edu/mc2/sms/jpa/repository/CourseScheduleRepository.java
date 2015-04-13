package edu.mc2.sms.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mc2.sms.jpa.entity.CourseSchedule;

public interface CourseScheduleRepository extends CrudRepository<CourseSchedule,Integer>{
	
}
