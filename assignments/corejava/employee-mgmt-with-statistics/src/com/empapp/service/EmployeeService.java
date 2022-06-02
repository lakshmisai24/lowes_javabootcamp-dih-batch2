package com.empapp.service;



import com.empapp.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public interface EmployeeService {
    public void createEmployee(int id, Employee E);

    public void viewEmployee(int id);

    public void updateEmployee(int id,Employee E);

    public void deleteEmployee(int id);

    public void viewAllEmployees();

    public void printStatistics();

    public void bulkImport();

    public void bulkExport();

    public long getEmployeeCountAgeGreaterThan(Predicate<Employee> condition);

    public List<Integer> getEmployeeIdsAgeGreaterThan(int age);

    public Map<String, Long> getEmployeeCountByDepartment();

    public Map<String, Long> getEmployeeCountByDepartmentOrdered();

    public Map<String, Double> getAvgEmployeeAgeByDept();

    public List<String> getDepartmentsHaveEmployeesMoreThan(int criteria);

    public List<String> getEmployeeNamesStartsWith(String prefix);




}
