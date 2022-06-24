package com.employee.app.exception;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.employee.app.controller.EmployeeController;
import com.employee.app.model.ResponseMessage;

@ControllerAdvice
public class EmployeeExceptionHandler {
	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class); 
			
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseMessage> handleMethodArgumentrrors(MethodArgumentNotValidException ex) {
		System.out.println("In MethodArgumentNotValidException " + ex.getErrorCount());
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(p -> p.getDefaultMessage())
				.collect(Collectors.toList());
		ResponseMessage response = new ResponseMessage("Failure: No proper method arguments", errors);
		System.out.println("Response data" + response.getStatus() + " " + response.getErrors());
		return ResponseEntity.internalServerError().body(response);
	}
		
		@ExceptionHandler(EmployeeException.class)
		public ResponseEntity<ResponseMessage>  handleErrors(EmployeeException ex) {
			ResponseMessage response = new ResponseMessage("Failure", ex.getMessage());
			return ResponseEntity.internalServerError().body(response);
		}
		
		
		@ExceptionHandler(RecordNotFoundException.class)
		public ResponseEntity<ResponseMessage>  handleErrors(RecordNotFoundException ex) {
			ResponseMessage response = new ResponseMessage("Failure", ex.getMessage());
			return ResponseEntity.internalServerError().body(response);
		}	
		
		
		
		@ExceptionHandler(Exception.class)
		public ResponseEntity<ResponseMessage>  handleGenericErrors(Exception ex) {
			ResponseMessage response = new ResponseMessage("Failure", ex.getMessage());
			return ResponseEntity.internalServerError().body(response);
		}

	}





