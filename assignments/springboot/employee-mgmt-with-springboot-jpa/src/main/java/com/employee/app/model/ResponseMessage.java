package com.employee.app.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // includes only not null fields in the json response
public class ResponseMessage {

	String status;
	String message;
	private List<String> errors;
	
	public ResponseMessage() {
		
	}

	public ResponseMessage(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ResponseMessage(String status, List<String> errors) {
		// TODO Auto-generated constructor stub
		this.status = status;
		this.errors = errors;
		
	}
	
	

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
