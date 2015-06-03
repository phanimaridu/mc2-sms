package edu.mc2.sms.cntrlr.rest;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.mc2.sms.jpa.entity.SchoolSchedule;
import edu.mc2.sms.service.SchoolScheduleService;

@RestController
@RequestMapping("/school_schedule")
public class SchoolScheduleRestController {

	@Autowired
	private SchoolScheduleService schoolScheduleService;
	

	@RequestMapping(method = RequestMethod.GET)
	public List<SchoolSchedule> getSchoolScheduls(@RequestParam(value = "name" , required = false) String name) {
		if(name == null || name.isEmpty()){
			return schoolScheduleService.getSchoolSchedules();
		}else{
			return schoolScheduleService.getSchoolSchedules(name);
		}
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public SchoolSchedule getSchoolSchedule(@PathVariable int id) {
		return schoolScheduleService.getSchoolSchedule(id);
	}

	
	
	@RequestMapping(method = RequestMethod.POST)
	public void createSchoolSchedule(@RequestBody SchoolSchedule schoolSchedule, UriComponentsBuilder uriBuilder,HttpServletResponse response) {
		schoolScheduleService.createSchoolSchedule(schoolSchedule);
		response.setStatus(HttpStatus.SC_CREATED);
		response.setHeader("Location", uriBuilder.path("/school_schedule/{id}")
				.buildAndExpand(schoolSchedule.getId()).toUriString());
			
	}
	
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public void editSchoolSchedule(@PathVariable int id,@RequestBody SchoolSchedule schoolSchedule, HttpServletResponse response) {
		schoolScheduleService.editSchoolSchedule(id, schoolSchedule);
	    response.setStatus(HttpStatus.SC_ACCEPTED);
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteSchoolSchedule(@PathVariable int id,HttpServletResponse response) {
		schoolScheduleService.deleteSchoolSchedule(id);
		response.setStatus(HttpStatus.SC_OK);
	}
	
	
}