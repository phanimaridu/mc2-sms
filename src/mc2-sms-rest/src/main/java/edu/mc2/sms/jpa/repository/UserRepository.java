package edu.mc2.sms.jpa.repository;

import edu.mc2.sms.jpa.entity.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String>{

	//List<User> findByLastName(String lastName);
	
}
