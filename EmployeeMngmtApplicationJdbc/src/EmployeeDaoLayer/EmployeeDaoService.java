package EmployeeDaoLayer;

import EmployeeModel.Employee;

import java.util.List;

public interface EmployeeDaoService {

    public boolean createEmployee(Employee e);

    public boolean updateEmployee(Employee e);

    public boolean deleteEmployee(int empId);

    public Employee get(int empId);

    public List<Employee> displayEmployees();
}
