package edu.mc2.sms.cntrlr.rest.staff;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffDummyController {

	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "Hello Staff";

	}

}
