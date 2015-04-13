package edu.mc2.sms.cntrlr.rest;


import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mc2.sms.excepion.rest.InternalServerError;
import edu.mc2.sms.jpa.entity.Person;
import edu.mc2.sms.jpa.repository.PersonRepository;

//TODO:Move Logics to Service Layer
@RestController
@RequestMapping("/public")
public class PublicRestController {

	@Autowired
	private PersonRepository repo;
	
	
	@RequestMapping(value = "/whoami", method = RequestMethod.GET)
	public Person getPerson(HttpServletResponse response) {
		Person person = null;
		try {
			String userName = SecurityContextHolder.getContext().getAuthentication().getName();
			person = repo.findOne(userName);
		} catch (Exception e) {
			throw new InternalServerError(e.getMessage());
		}
	
		if (person == null) {
			response.setStatus(HttpStatus.SC_PARTIAL_CONTENT);
			response.addHeader("Status Message", "Person Not Registerd");
		}
		
		return person;
		
	}
	

}