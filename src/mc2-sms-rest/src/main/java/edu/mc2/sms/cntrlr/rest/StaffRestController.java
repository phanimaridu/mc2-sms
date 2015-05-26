package edu.mc2.sms.cntrlr.rest;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.mc2.sms.jpa.entity.Staff;
import edu.mc2.sms.service.StaffService;


@RestController
@RequestMapping("/staff")
public class StaffRestController {

	@Autowired
	private StaffService staffService;
	

	@RequestMapping(method = RequestMethod.GET)
	public List<Staff> getStaffs() {
		return staffService.getStaffs();
	}
	
	
	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
	public Staff getStaff(@PathVariable String userName) {
		return staffService.getStaff(userName);
	}

	
	
	@RequestMapping(method = RequestMethod.POST)
	public void createStaff(@RequestBody Staff staff, UriComponentsBuilder uriBuilder,HttpServletResponse response) {
		staffService.createStaff(staff);
		response.setStatus(HttpStatus.SC_CREATED);
		response.setHeader("Location", uriBuilder.path("/staff/{userName}")
				.buildAndExpand(staff.getUserName()).toUriString());
			
	}
	
	
	
	@RequestMapping(value = "/{userName}",method = RequestMethod.PUT)
	public void editStaff(@PathVariable String userName,@RequestBody Staff staff, HttpServletResponse response) {
		staffService.editStaff(userName, staff);
	    response.setStatus(HttpStatus.SC_ACCEPTED);
	}
	
	
	
	@RequestMapping(value = "/{userName}", method = RequestMethod.DELETE)
	public void deleteStaff(@PathVariable String userName,HttpServletResponse response) {
		staffService.deleteStaff(userName);
		response.setStatus(HttpStatus.SC_OK);
	}
	
	
}