package edu.mc2.sms.cntrlr.rest.student;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentDummyController {

	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "Hello Student";

	}

}
