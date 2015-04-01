package edu.mc2.sms.cntrlr.rest.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mc2.sms.dao.UserDAO;
import edu.mc2.sms.excepion.rest.ResourceNotFoundException;
import edu.mc2.sms.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDAO userDAO;


	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUsers() {
		List<User> users = userDAO.find(0, 0);
		if (users.size() == 0) {
			throw new ResourceNotFoundException("No Users Found");
		} else {
			return users;
		}
	}

	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public User getUser(@PathVariable String name) {

		User user = userDAO.find(name);
		if (user == null) {
			throw new ResourceNotFoundException("User not found");
		} else {
			return user;
		}

	}

	/*
	 * @RequestMapping(method = RequestMethod.GET) 
	 * public User find(@RequestParam(value = "name", required = true) String name) 
	 * { return  userDAO.find(name); }
	 */

}
