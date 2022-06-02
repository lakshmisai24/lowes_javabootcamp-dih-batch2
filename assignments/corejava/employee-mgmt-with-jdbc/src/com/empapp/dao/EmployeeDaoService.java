package com.empapp.dao;

import com.empapp.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public interface EmployeeDaoService {

    public boolean createemployee(Employee e);

    public boolean updateemployee(Employee e);

    public boolean deleteemployee(int empId);

    public Employee get(int empId);

    public List<Employee> displayemployees();

    public void bulkImport();

    public void bulkExport();

    public long getEmployeeCountAgeGreaterThan(Predicate<Employee> condition);

    public List<Integer> getEmployeeIdsAgeGreaterThan(int age);

    public Map<String, Long> getEmployeeCountByDepartment();

    public Map<String, Long> getEmployeeCountByDepartmentOrdered();

    public Map<String, Double> getAvgEmployeeAgeByDept();

    public List<String> getDepartmentsHaveEmployeesMoreThan(int criteria);

    public List<String> getEmployeeNamesStartsWith(String prefix);

    public Map<String, Double> getAvgEmployeeServiceByDept();




}
