package com.employee.app.controller;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.employee.app.exception.EmployeeException;
import com.employee.app.model.Employee;
import com.employee.app.model.ResponseMessage;
import com.employee.app.service.EmployeeService;
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
		Logger logger = LoggerFactory.getLogger(EmployeeController.class); 

		@Autowired
		EmployeeService empService;

		 @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
		            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
		    public ResponseEntity<ResponseMessage> create(@Valid @RequestBody Employee employee) throws URISyntaxException {	    	
		        Employee empCreated = empService.create(employee);
		        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(empCreated.getEmpid()).toUri();
		        ResponseMessage response = new ResponseMessage("Success", "Employee created successfully");
		    
		        return ResponseEntity.created(location).body(response);
		    }
		

		// List Employees
		@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
		public List<Employee> getAll() throws EmployeeException {
			return empService.list();
		}

		// Get Account
		@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
		public Employee get(@PathVariable int id) {
			return empService.get(id);
		}

		// Update Account
		@PutMapping(path="/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<String> update(@Valid @PathVariable int id, @RequestBody Employee employee) {
			employee.setEmpid(id);
			Employee updatedAcc = empService.update(id, employee);
			 URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(updatedAcc.getEmpid()).toUri();
			// ResponseMessage response = new ResponseMessage("Success", "Employee updated successfully");
			 return ResponseEntity.ok().body("Employee Updated");
		}
		

		// Delete Account
		@DeleteMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<String> delete(@PathVariable int id) {
			empService.delete(id);
			return ResponseEntity.ok().body("Employee deleted successfully");
		}
		
	
}
