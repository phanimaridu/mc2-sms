package edu.mc2.sms.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
public class ErrorMessage {

	
	public ErrorMessage() {
		super();
	}

	public ErrorMessage(Throwable t) {
		super();
		this.errorMessage = t.getMessage();
	}
	
	public ErrorMessage(int errorCode,Throwable t) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = t.getMessage();
	}
	
	public ErrorMessage(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	
	private int errorCode;
	private String errorMessage;
	
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
}
