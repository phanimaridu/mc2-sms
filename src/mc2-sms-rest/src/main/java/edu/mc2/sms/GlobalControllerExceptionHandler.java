package edu.mc2.sms;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mc2.sms.excepion.ConflictException;
import edu.mc2.sms.excepion.ResourceNotFoundException;
import edu.mc2.sms.model.ErrorMessage;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorMessage handleException(IllegalArgumentException iae) {
		return new ErrorMessage(iae);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.CONFLICT)
	@ResponseBody
	public ErrorMessage handleException(ConflictException ce) {
		return new ErrorMessage(ce);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorMessage handleException(ResourceNotFoundException rnfe) {
		return new ErrorMessage(rnfe);
	}
	
	/*
	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorMessage handleException(Exception e) {
		return new ErrorMessage(e);
	}
	 */
	

}
