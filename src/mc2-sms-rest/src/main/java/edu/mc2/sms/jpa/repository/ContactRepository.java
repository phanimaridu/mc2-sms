package edu.mc2.sms.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mc2.sms.jpa.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact,String>{

	
}
