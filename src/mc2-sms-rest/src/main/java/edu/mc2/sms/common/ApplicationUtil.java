package edu.mc2.sms.common;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApplicationUtil {

	
	public static ResponseEntity<String> getCreateResponseEntity(URI uri) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uri);
		return new ResponseEntity<String>(responseHeaders,HttpStatus.CREATED);
	}
}
