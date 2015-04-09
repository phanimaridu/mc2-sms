package edu.mc2.sms.cntrlr.rest.common;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
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
import edu.mc2.sms.jpa.entity.User;
import edu.mc2.sms.jpa.repository.UserRepository;


@RestController
@RequestMapping("/users")
public class UserRestController {

	@Autowired
	private UserRepository repo;
	

	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUsers() {
		List<User> users = null;
		try {
			users = (List<User>) repo.findAll();
		} catch (Exception e) {
			throw new InternalServerError(e.getMessage());
		}

		if (users == null || users.size() == 0) {
			throw new ResourceNotFoundException("No Users Found");
		} else {
			return users;
		}
	}
	
	
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public User getUser(@PathVariable String name) {
		User user = null;
		try {
			user = repo.findOne(name);
		} catch (Exception e) {
			throw new InternalServerError(e.getMessage());
		}
	
		if (user == null) {
			throw new ResourceNotFoundException("User not found");
		} else {
			return user;
		}
	}

	
	
	@RequestMapping(method = RequestMethod.POST)
	public void createUser(@RequestBody User user, UriComponentsBuilder uriBuilder,HttpServletResponse response) {

		if(user == null || user.getUserName() == null || user.getUserName().isEmpty() ||
				 user.getPassword().isEmpty()|| user.getPassword().isEmpty()){
			throw new BadRequestException("Invalid User Data");
		}
		
		
		try {
			
			if(repo.findOne(user.getUserName()) != null){
				throw new ConflictException("User Alreasy Exists");
			}
			
			//encode password to md5 hash
			//TODO:Use salt : can also use userName as salt ?
			user.setPassword(new Md5PasswordEncoder().encodePassword(user.getPassword(), null));
			
			repo.save(user);
			
			response.setStatus(HttpStatus.SC_CREATED);
			response.setHeader("Location", uriBuilder.path("/users/{userName}").buildAndExpand(user.getUserName()).toUriString());
			
		} catch (ConflictException ce) {
			throw ce;
		}catch (Exception e) {
			throw new InternalServerError(e.getMessage());
		}
	}
	
	
	
	@RequestMapping(value = "/{name}",method = RequestMethod.PUT)
	public void editUser(@PathVariable String name,@RequestBody User user, HttpServletResponse response) {
		
		if(user == null || user.getUserName() == null || user.getUserName().isEmpty() ||
				 user.getPassword().isEmpty()|| user.getPassword().isEmpty()){
			throw new BadRequestException("Invalid User Data");
		}
		
		try {
			
			if(repo.findOne(name) == null){
				throw new ResourceNotFoundException("User Not Found");
			}
			
			//encode password to md5 hash
			//TODO:Use salt : can also use userName as salt ?
			user.setPassword(new Md5PasswordEncoder().encodePassword(user.getPassword(), null));
			
			repo.save(user);
			
			response.setStatus(HttpStatus.SC_ACCEPTED);
		} catch (ResourceNotFoundException rnfe) {
			throw rnfe;
		}catch (Exception e) {
			throw new InternalServerError(e.getMessage());
		}
		
		
	}
	
	
	
	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable String name,HttpServletResponse response) {
		try {
			User user = repo.findOne(name);
			if (user == null) {
				throw new ResourceNotFoundException("User not found");
			} else {
				repo.delete(user);
				response.setStatus(HttpStatus.SC_OK);
			}
		}catch (ResourceNotFoundException rnfe) {
			throw rnfe;
		}catch (Exception e) {
			throw new InternalServerError(e.getMessage());
		}
	}
	
	
	/*
	 * @RequestMapping(method = RequestMethod.GET) 
	 * public User find(@RequestParam(value = "name", required = true) String name) 
	 * { return  userDAO.find(name); }
	 */

}