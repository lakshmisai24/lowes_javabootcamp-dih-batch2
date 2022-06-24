package com.lowes.bankingapp.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lowes.bankingapp.controller.TransactionController;
import com.lowes.bankingapp.model.ResponseMessage;

@ControllerAdvice
public class TransactionExceptionHandler {
	
	Logger logger = LoggerFactory.getLogger(TransactionController.class); 
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseMessage> handleMethodArgumentrrors(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(p -> p.getDefaultMessage())
				.collect(Collectors.toList());
		ResponseMessage response = new ResponseMessage("Failure: No proper method arguments", errors);
		System.out.println("Response data" + response.getStatus() + " " + response.getErrors());
		return ResponseEntity.internalServerError().body(response);
	}
	
	@ExceptionHandler(TransactionException.class)
	public ResponseEntity<ResponseMessage>  handleErrors(TransactionException ex) {
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
