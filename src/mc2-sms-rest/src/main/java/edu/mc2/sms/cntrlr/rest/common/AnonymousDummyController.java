package edu.mc2.sms.cntrlr.rest.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anonymous")
public class AnonymousDummyController {

	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "Hello Anonymous";

	}

}
