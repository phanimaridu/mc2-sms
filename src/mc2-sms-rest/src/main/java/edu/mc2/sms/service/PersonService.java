package edu.mc2.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mc2.sms.excepion.ResourceNotFoundException;
import edu.mc2.sms.jpa.entity.Person;
import edu.mc2.sms.jpa.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repo;
	
	public Person getPerson(String userName) {
		Person person = repo.findOne(userName);
		if (person == null ) {
			throw new ResourceNotFoundException("No Person Found");
		} else {
			return person;
		}
	}

	
	
}
