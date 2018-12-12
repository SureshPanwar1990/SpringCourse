package com.applespring.demo;

import org.springframework.http.HttpStatus;

public class ErrorResponse 
{
	private HttpStatus status;
	private String errorName;
	private String message;

	
	public ErrorResponse(HttpStatus status, String errorName, String message) {
		super();
		this.status = status;
		this.errorName = errorName;
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getErrorName() {
		return errorName;
	}
	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
