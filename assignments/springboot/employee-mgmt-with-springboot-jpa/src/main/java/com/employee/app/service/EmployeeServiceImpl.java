package com.employee.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.app.exception.EmployeeException;
import com.employee.app.model.Employee;
import com.employee.app.repository.EmployeeRepository;





@Service
public class EmployeeServiceImpl implements EmployeeService{

	 Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	    @Autowired
	    EmployeeRepository repo;
	
	@Override
	public Employee create(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public List<Employee> list() throws EmployeeException {
		List<Employee> empList = repo.findAll();
    	if (empList.isEmpty()) {
            throw new EmployeeException("Sorry no employees found in the database");
        }
    	return empList;
	}

	@Override
	public Employee get(int id) {
		return repo.findById(id).get();
	}

	@Override
	public Employee update(int id, Employee employee) {
		return repo.save(employee);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
		
	}
	
}




