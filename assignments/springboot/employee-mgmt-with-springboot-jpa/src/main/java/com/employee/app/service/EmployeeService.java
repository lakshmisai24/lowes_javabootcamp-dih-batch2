package com.employee.app.service;

import java.util.List;

import org.springframework.web.bind.MethodArgumentNotValidException;

import com.employee.app.exception.EmployeeException;
import com.employee.app.model.Employee;

public interface EmployeeService {
	public Employee create(Employee employee);
	public List<Employee> list() throws EmployeeException;
	public Employee get(int id);
	public Employee update(int id, Employee employee);
	public void delete(int id);

}
