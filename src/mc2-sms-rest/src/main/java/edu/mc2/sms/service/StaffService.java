package edu.mc2.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mc2.sms.excepion.ConflictException;
import edu.mc2.sms.excepion.ResourceNotFoundException;
import edu.mc2.sms.jpa.entity.Staff;
import edu.mc2.sms.jpa.repository.StaffRepository;

@Service
@Transactional
public class StaffService {

	@Autowired
	private StaffRepository repo;
	

	public List<Staff> getStaffs() {
		List<Staff> staffs = (List<Staff>) repo.findAll();
		if (staffs == null || staffs.size() == 0) {
			throw new ResourceNotFoundException("No Staff Found");
		} else {
			return staffs;
		}
	}
	
	
	public Staff getStaff(String userName) {
		Staff staff = repo.findOne(userName);
		if (staff == null ) {
			throw new ResourceNotFoundException("No Staff Found");
		} else {
			return staff;
		}
	}

	
	public void createStaff(Staff staff) {
		
		if(staff == null || staff.getUserName() == null || staff.getUserName().isEmpty() ||
				staff.getPassword() == null|| staff.getPassword().isEmpty()){
			throw new IllegalArgumentException("Invalid Staff Data");
		}
		
		if (repo.findOne(staff.getUserName()) != null) {
			throw new ConflictException("User Already Exists");
		}
		staff.setPassword(new BCryptPasswordEncoder().encode(staff.getPassword()));
		repo.save(staff);
	}

	
	
	public void editStaff(String userName, Staff staff) {
		if(staff == null || staff.getUserName() == null || staff.getUserName().isEmpty() ||
				staff.getPassword() == null|| staff.getPassword().isEmpty()){
			throw new IllegalArgumentException("Invalid Staff Data");
		}
		
		if (repo.findOne(userName) == null) {
			throw new ResourceNotFoundException("Staff Not Found");
		}
		staff.setUserName(userName);
		// encode password to BCrypt hash
		staff.setPassword(new BCryptPasswordEncoder().encode(staff.getPassword()));
		repo.save(staff);
	}
	
	
	
	public void deleteStaff(String userName) {
		Staff staff = repo.findOne(userName);
		if (staff == null) {
			throw new ResourceNotFoundException("Staff not found");
		} else {
			repo.delete(staff);
		}
	}
	
	
}
