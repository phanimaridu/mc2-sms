package edu.mc2.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mc2.sms.excepion.ConflictException;
import edu.mc2.sms.excepion.ResourceNotFoundException;
import edu.mc2.sms.jpa.entity.SchoolSchedule;
import edu.mc2.sms.jpa.repository.SchoolScheduleRepository;

@Service
@Transactional
public class SchoolScheduleService {

	@Autowired
	private SchoolScheduleRepository repo;
	

	public List<SchoolSchedule> getSchoolSchedules() {
		List<SchoolSchedule> schoolSchedules = (List<SchoolSchedule>) repo.findAll();
		if (schoolSchedules == null || schoolSchedules.size() == 0) {
			throw new ResourceNotFoundException("No SchoolSchedules Found");
		} else {
			return schoolSchedules;
		}
	}
	
	public List<SchoolSchedule> getSchoolSchedules(String eventName) {
		List<SchoolSchedule> schoolSchedules = (List<SchoolSchedule>) repo.findByEventName(eventName);
		if (schoolSchedules == null || schoolSchedules.size() == 0) {
			throw new ResourceNotFoundException("No SchoolSchedules Found");
		} else {
			return schoolSchedules;
		}
	}
	
	
	public SchoolSchedule getSchoolSchedule(int id) {
		SchoolSchedule schoolSchedule = repo.findOne(id);
		if (schoolSchedule == null ) {
			throw new ResourceNotFoundException("No SchoolSchedule Found");
		} else {
			return schoolSchedule;
		}
	}

	
	public void createSchoolSchedule(SchoolSchedule schoolSchedule) {
		
		if(schoolSchedule == null ){
			throw new IllegalArgumentException("Invalid SchoolSchedule Data");
		}
		
		if (repo.findOne(schoolSchedule.getId()) != null) {
			throw new ConflictException("SchoolSchedule Already Exists");
		}
		repo.save(schoolSchedule);
	}

	
	
	public void editSchoolSchedule(int id, SchoolSchedule schoolSchedule) {
		if(schoolSchedule == null ){
			throw new IllegalArgumentException("Invalid SchoolSchedule Data");
		}
		
		if (repo.findOne(id) == null) {
			throw new ResourceNotFoundException("SchoolSchedule Not Found");
		}
		schoolSchedule.setId(id);
		repo.save(schoolSchedule);
	}
	
	
	
	public void deleteSchoolSchedule(int id) {
		SchoolSchedule schoolSchedule = repo.findOne(id);
		if (schoolSchedule == null) {
			throw new ResourceNotFoundException("SchoolSchedule not found");
		} else {
			repo.delete(schoolSchedule);
		}
	}
	
	
}
