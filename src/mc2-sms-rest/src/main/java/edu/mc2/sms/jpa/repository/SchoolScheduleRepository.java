package edu.mc2.sms.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.mc2.sms.jpa.entity.SchoolSchedule;

public interface SchoolScheduleRepository extends CrudRepository<SchoolSchedule,Integer>{
	
	List<SchoolSchedule> findByEventName(String eventName);
	
}
