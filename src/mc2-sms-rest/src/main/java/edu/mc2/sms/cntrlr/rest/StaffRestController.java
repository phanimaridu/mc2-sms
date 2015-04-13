package edu.mc2.sms.cntrlr.rest;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.mc2.sms.excepion.rest.BadRequestException;
import edu.mc2.sms.excepion.rest.ConflictException;
import edu.mc2.sms.excepion.rest.InternalServerError;
import edu.mc2.sms.excepion.rest.ResourceNotFoundException;
import edu.mc2.sms.jpa.entity.Staff;
import edu.mc2.sms.jpa.repository.StaffRepository;

//TODO:Move the code from Rest Controllers method to another method
//Inside Direct Rest Method write logic to respond based on request param etc...
//Other method will get data from Repos and does null checks

//TODO:Move Logics to Service Layer
@RestController
@RequestMapping("/staff")
public class StaffRestController {

	@Autowired
	private StaffRepository repo;
	

	
	@RequestMapping(method = RequestMethod.GET)
	public List<Staff> getUsers() {
		List<Staff> staffs = null;
		try {
			staffs = (List<Staff>) repo.findAll();
		} catch (Exception e) {
			throw new InternalServerError(e.getMessage());
		}

		if (staffs == null || staffs.size() == 0) {
			throw new ResourceNotFoundException("No Staff Found");
		} else {
			return staffs;
		}
	}
	
	
	
	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
	public Staff getStaff(@PathVariable String userName) {
		Staff staff = null;
		try {
			staff = repo.findOne(userName);
		} catch (Exception e) {
			throw new InternalServerError(e.getMessage());
		}
	
		if (staff == null) {
			throw new ResourceNotFoundException("Staff not found");
		} else {
			return staff;
		}
	}

	
	
	@RequestMapping(method = RequestMethod.POST)
	public void createStaff(@RequestBody Staff staff, UriComponentsBuilder uriBuilder,HttpServletResponse response) {

		if(staff == null || staff.getUserName() == null || staff.getUserName().isEmpty() ||
				staff.getPassword().isEmpty()|| staff.getPassword().isEmpty()){
			throw new BadRequestException("Invalid Staff Data");
		}
		
		
		try {
			
			if(repo.findOne(staff.getUserName()) != null){
				throw new ConflictException("User Alreasy Exists");
			}
			
			staff.setPassword(new BCryptPasswordEncoder().encode(staff.getPassword()));
			repo.save(staff);
			
			response.setStatus(HttpStatus.SC_CREATED);
			response.setHeader("Location", uriBuilder.path("/staff/{userName}").buildAndExpand(staff.getUserName()).toUriString());
			
		} catch (ConflictException ce) {
			throw ce;
		}catch (Exception e) {
			throw new InternalServerError(e.getMessage());
		}
	}
	
	
	
	@RequestMapping(value = "/{userName}",method = RequestMethod.PUT)
	public void editStaff(@PathVariable String userName,@RequestBody Staff staff, HttpServletResponse response) {
		
		if(staff == null || staff.getUserName() == null || staff.getUserName().isEmpty() ||
				staff.getPassword().isEmpty()|| staff.getPassword().isEmpty()){
			throw new BadRequestException("Invalid Staff Data");
		}
		
		try {
			
			if(repo.findOne(userName) == null){
				throw new ResourceNotFoundException("Staff Not Found");
			}
			
			//encode password to md5 hash
			staff.setPassword(new BCryptPasswordEncoder().encode(staff.getPassword()));
			
			repo.save(staff);
			
			response.setStatus(HttpStatus.SC_ACCEPTED);
		} catch (ResourceNotFoundException rnfe) {
			throw rnfe;
		}catch (Exception e) {
			throw new InternalServerError(e.getMessage());
		}
		
		
	}
	
	
	
	@RequestMapping(value = "/{userName}", method = RequestMethod.DELETE)
	public void deleteStaff(@PathVariable String userName,HttpServletResponse response) {
		try {
			Staff staff = repo.findOne(userName);
			if (staff == null) {
				throw new ResourceNotFoundException("Staff not found");
			} else {
				repo.delete(staff);
				response.setStatus(HttpStatus.SC_OK);
			}
		}catch (ResourceNotFoundException rnfe) {
			throw rnfe;
		}catch (Exception e) {
			throw new InternalServerError(e.getMessage());
		}
	}
	
	
}