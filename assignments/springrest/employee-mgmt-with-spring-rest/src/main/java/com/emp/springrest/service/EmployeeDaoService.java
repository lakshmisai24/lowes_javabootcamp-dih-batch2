package com.emp.springrest.service;



import com.emp.springrest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@Service
public interface EmployeeDaoService {

    public Employee createEmployee(Employee e);

    public Employee updateEmployee(int empId,Employee e);

    public boolean deleteEmployee(int empId);

    public Employee get(int empId);

    public List<Employee> displayEmployees();

}
