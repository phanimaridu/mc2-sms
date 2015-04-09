package edu.mc2.sms.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.mc2.sms.jpa.entity.Person;

public interface PersonRepository extends CrudRepository<Person,String>{

	List<Person> findByLastName(String lastName);
	
}
