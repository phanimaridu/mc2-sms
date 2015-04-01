package edu.mc2.sms.cntrlr.rest.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminDummyController {

	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "Hello Admin";

	}

}
