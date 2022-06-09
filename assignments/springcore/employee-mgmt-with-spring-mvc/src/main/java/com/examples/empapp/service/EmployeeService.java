package com.examples.empapp.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.examples.empapp.dao.EmployeeDao;
import com.examples.empapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {
	

	@Autowired
	public EmployeeDao empDao;
	private static Map<String, Employee> employees = new LinkedHashMap<String, Employee>();
	public void add(Employee employee)
	{
		employee.setId(UUID.randomUUID().toString());
		employees.put(employee.getId(), employee);
		empDao.addEmployee(employee);
	}
	
	public void update(Employee employee)
	{
		employees.put(employee.getId(), employee);
		System.out.println("am in update dao");
		empDao.update(employee);
	}
	
	public Employee get(String empId)
	{

		//return employees.get(empId);
		return empDao.get(empId);
	}
	
	public void delete(String empId)

	{
		//employees.remove(empId);
		empDao.delete(empId);
	}	
	
	public List<Employee> list()
	{
		//return new ArrayList<Employee>(employees.values());
		return new ArrayList<>(empDao.getAllEmployees());
	}	
	
}
