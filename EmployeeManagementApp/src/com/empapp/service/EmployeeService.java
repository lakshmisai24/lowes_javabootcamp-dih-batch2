package com.empapp.service;

import com.empapp.model.Employee;

public interface EmployeeService {

    public void createEmployee(Employee[] e);

    public void viewEmployee(int employeeid, Employee[] e);

    public void updateEmployee(int employeeid,Employee[] e);

    public void deleteEmployee(int employeeid, Employee[] e);

    public void viewAllEmployees(Employee[] e);
}