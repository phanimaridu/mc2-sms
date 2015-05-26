package edu.mc2.sms.cntrlr.rest;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mc2.sms.jpa.entity.Person;
import edu.mc2.sms.service.PersonService;

@RestController
@RequestMapping("/public")
public class PublicRestController {

	@Autowired
	private PersonService personService;
	
	
	@RequestMapping(value = "/whoami", method = RequestMethod.GET)
	public Person getPerson(HttpServletResponse response) {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		return personService.getPerson(userName);
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public Map<String,String> getTestData() {
		
		Map<String,String> result = new HashMap<String, String>();
		result.put("Name ", "Jack the Ripper");
		result.put("City", "London");
		result.put("Occupation", "Bad Guy");
		
		return result;
	}
	

}