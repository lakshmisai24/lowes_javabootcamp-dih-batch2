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

import com.lowes.bankingapp.model.Account;
import com.lowes.bankingapp.model.ResponseMessage;
import com.lowes.bankingapp.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accService;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ResponseMessage> create(@Valid @RequestBody Account account) throws URISyntaxException {	    	
        Account accCreated = accService.create(account);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(accCreated.getId()).toUri();
        ResponseMessage response = new ResponseMessage("Success", "Account created successfully");
    
        return ResponseEntity.created(location).body(response);
    }
	

	@PutMapping(path="/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> update(@Valid @PathVariable int id, @RequestBody Account account) {
		account.setId(id);
		Account accupdated = accService.update(id, account);
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(accupdated.getId()).toUri();
		// ResponseMessage response = new ResponseMessage("Success", "Account updated successfully");
		 return ResponseEntity.ok().body("Account Updated");
	}
	
	
	// List Employees
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Account> getAll() {
		return accService.list();
	}

	// Get Account
	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Account get(@PathVariable int id) {
		return accService.get(id);
	}
	
	// Delete Account
			@DeleteMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
			public ResponseEntity<String> delete(@PathVariable int id) {
				accService.delete(id);
				return ResponseEntity.ok().body("Account deleted successfully");
			}
	
	
}
