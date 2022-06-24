package com.lowes.bankingapp.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lowes.bankingapp.model.ResponseMessage;
import com.lowes.bankingapp.model.Transaction;
import com.lowes.bankingapp.service.TransactionService;

@RestController
public class TransactionController {
	@Autowired
	TransactionService transService;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ResponseMessage> create(@Valid @RequestBody Transaction transaction) throws URISyntaxException {	    	
		Transaction transCreated = transService.create(transaction);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transCreated.getId()).toUri();
        ResponseMessage response = new ResponseMessage("Success", "Transaction created successfully");
    
        return ResponseEntity.created(location).body(response);
    }
	

	@PutMapping(path="/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> update(@Valid @PathVariable int id, @RequestBody Transaction transaction) {
		transaction.setId(id);
		Transaction transCreated = transService.update(id, transaction);
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(transCreated.getId()).toUri();
		// ResponseMessage response = new ResponseMessage("Success", "Transaction updated successfully");
		 return ResponseEntity.ok().body("Transaction Updated");
	}
	
	
	// List Employees
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Transaction> getAll() {
		return transService.list();
	}

	// Get Account
	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Transaction get(@PathVariable int id) {
		return transService.get(id);
	}
	
	// Delete Account
			@DeleteMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
			public ResponseEntity<String> delete(@PathVariable int id) {
				transService.delete(id);
				return ResponseEntity.ok().body("Transaction deleted successfully");
			}
	
}
