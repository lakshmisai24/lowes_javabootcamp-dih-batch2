package com.emp.service;

import com.employeecollections.model.Employee;

public interface EmployeeService {
    public void createEmployee(int id,Employee E);

    public void viewEmployee(int id);

    public void updateEmployee(int id,Employee E);

    public void deleteEmployee(int id);

    public void viewAllEmployees();
}
