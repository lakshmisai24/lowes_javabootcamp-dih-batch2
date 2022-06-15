package com.emp.springrest.controller;

import com.emp.springrest.service.EmployeeDaoService;
import com.emp.springrest.exception.EmployeeNotFoundException;
import com.emp.springrest.exception.RecordNotFoundException;
import com.emp.springrest.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/employees")//change it to plural
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    @Qualifier("empServImpl")
    EmployeeDaoService edaoService;

    //Create Account

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> create(@RequestBody Employee employee) throws URISyntaxException {
       // Add employee logic
        edaoService.createEmployee(employee);
        return ResponseEntity.ok().body("Employee created successfully");
    }

    //get employee
    @GetMapping("/{id}")
    public Employee get(@PathVariable int id) throws EmployeeNotFoundException {
        if (edaoService.get(id).equals(0)) {
            throw new RecordNotFoundException("Employee not found");
        }
        return edaoService.get(id);
    }

    //Update employee
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Employee employee) {
        Employee updatedemp = edaoService.updateEmployee(id,employee);
        return ResponseEntity.ok().body("Employee updated Successfully");
    }

    //Delete Account
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        edaoService.deleteEmployee(id);
        return ResponseEntity.ok().body("Employee deleted Successfully");
    }

    @GetMapping
    public List<Employee> getAllEmployees() throws EmployeeNotFoundException {
        if ((edaoService.displayEmployees()) == null) {
            throw new RecordNotFoundException("Employee not found");
        }
        return edaoService.displayEmployees();
    }



}
