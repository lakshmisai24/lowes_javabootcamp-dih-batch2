package EmployeeService;

import EmployeeException.AgeHandleException;
import EmployeeService.*;
import EmployeeModel.Employee;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static EmployeeService.EmployeeValidation.handleError;
import static EmployeeService.EmployeeValidation.validate;

public class EmployeeServiceImplem implements EmployeeService {

    //Date Fields
    LocalDate date2 = LocalDate.now();
    LocalDateTime createTime2 = LocalDateTime.now();
    LocalDateTime modifyTime2 = LocalDateTime.now();
    Map<Integer, Employee> EmpMap = new HashMap<>();

    //Initialise Employee Map With Data
    public EmployeeServiceImplem() {
        EmpMap.put(1, new Employee(1, "Anil", 45, "Delivery Manager", "Operations", "India", 46000, date2, createTime2, createTime2));
        EmpMap.put(2, new Employee(2, "Kiran", 35, "Quality Analyst", "Quality", "India", 50000, date2, createTime2, createTime2));
        EmpMap.put(3, new Employee(3, "Hari", 42, "Manager", "Operations", "USA", 250000, date2, createTime2, createTime2));
        EmpMap.put(4, new Employee(4, "Swapna", 26, "Associate", "Operations", "UK", 60000, date2, createTime2, createTime2));
        EmpMap.put(5, new Employee(5, "Baobby", 30, "Lead Associate", "Quality", "India", 47000, date2, createTime2, createTime2));
    }

    public int createEmpid() {

        int eid = EmpMap.size() + 1;
        return eid;
    }

    @Override
    public void createEmployee(int id, Employee E) {
        boolean valStatus = validate(E, emp -> emp.getAge() >= 20 && emp.getAge() <= 60 && emp.getSalary() > 0
                && emp.getDepartment().equals("Admin") || emp.getDepartment().equals("IT") || emp.getDepartment().equals("Sales")
                || emp.getDepartment().equals("Operations") || emp.getDepartment().equals("Quality") && emp.getDepartment().equals("UK") &&
                emp.getDepartment().equals("India") || emp.getDepartment().equals("USA"));

        if (valStatus) {
            EmpMap.put(id, E);
            System.out.println("Employee Created Successfully");
        } else {
            handleError("Invalid Age or Salary or Department or Country ", msg -> {
                System.out.println("Validation Error:");
            });
        }
    }


    @Override
    public void viewEmployee(int id) {
        boolean found = false;

        Iterator<Employee> it = EmpMap.values().iterator();
        while (it.hasNext()) {
            Employee e = it.next();
            if (e.getEmpid() == id) {
                System.out.println("Emp ID \t Name \t Age \t Designation \t Department \t Country \t Salary \t DateofJoining  \t CreatedTime   \t ModifiedTime");
                System.out.printf("%d   \t %s   \t%d  \t%s   \t%s   \t %s     \t %d  \n ", e.getEmpid(), e.getName(),
                        e.getAge(), e.getDesignation(), e.getDepartment(), e.getCountry(), e.getSalary(),
                        e.getDateofjoining(),
                        e.getCreatedTime(), e.getModifiedtime());
                found = true;
            }
        }
        if (!found)
            System.out.println("Employee record not found ");
    }

    @Override
    public void updateEmployee(int id, Employee E1) {
        boolean valStatus = validate(E1, emp -> emp.getAge() >= 20 && emp.getAge() <= 60 && emp.getSalary() > 0
                && emp.getDepartment().equals("Admin") || emp.getDepartment().equals("IT") || emp.getDepartment().equals("Sales")
                || emp.getDepartment().equals("Operations") || emp.getDepartment().equals("Quality") && emp.getDepartment().equals("UK") &&
                emp.getDepartment().equals("India") || emp.getDepartment().equals("USA"));

        if (valStatus) {
            Iterator<Employee> it = EmpMap.values().iterator();
            while (it.hasNext()) {
                Employee Eit = it.next();
                if (Eit.getEmpid() == id) {
                    EmpMap.put(id, E1);
                }
            }
            System.out.println("Employee Details Updated Successfully");
        } else {
            handleError("Invalid Age or Salary or Department or Country ", msg -> {
                System.out.println("Validation Error:");
            });
        }
    }


    @Override
    public void deleteEmployee(int id) {
        boolean found = false;
        Iterator<Employee> it = EmpMap.values().iterator();
        while (it.hasNext()) {
            Employee e = it.next();
            if (e.getEmpid() == id) {
                EmpMap.remove(id);
                found = true;
            }
        }

        if (!found)
            System.out.println("Employee record not found ");
        else
            System.out.println("Employee Id: " + id + " deleted");
    }

    @Override
    public void viewAllEmployees() {
        System.out.println("Emp ID \t Name \t Age \t Designation   \t Department    \t Country   \t Salary  \t DateofJoining  \t CreatedTime   \t ModifiedTime");
        Iterator<Employee> it = EmpMap.values().iterator();
        while (it.hasNext()) {
            Employee e = it.next();
            System.out.printf("%d   \t %s   \t%d  \t%s   \t%s   \t %s     \t %d  \n ", e.getEmpid(), e.getName(),
                    e.getAge(), e.getDesignation(), e.getDepartment(), e.getCountry(), e.getSalary(), e.getDateofjoining(), e.getCreatedTime(), e.getModifiedtime());
        }
    }

    @Override
    public void printStatistics() {
        System.out.println(" Number of Employees older than forty years:  " +
               getEmployeeCountAgeGreaterThan(e->e.getAge() > 20 ));
        System.out.println("List of Employee Ids older than 40 years: " +
               getEmployeeIdsAgeGreaterThan(20));
        System.out.println("Employee count by Department: " +
                getEmployeeCountByDepartment());
        System.out.println("Employee count by Department sorted: " +
                getEmployeeCountByDepartmentOrdered());
        System.out.println("Average Employee age by Department: " +
                getAvgEmployeeAgeByDept());
        System.out.println("List Departments have more than 3 employees: " +
                getDepartmentsHaveEmployeesMoreThan(2));
        System.out.println("List Employees starts with " + "'S':" +
              getEmployeeNamesStartsWith("S"));
        System.out.println("Average Employee Service by Department: " +
                getAvgEmployeeServiceByDept());

    }

    @Override
    public void bulkImport() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ImportExportData imp = new ImportExportData();
        imp.Importingdata(EmpMap, executorService);
        executorService.shutdown();
        return;
    }

    @Override
    public void bulkExport() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExportEmpDataService expd = new ExportEmpDataService();
        expd.ExportingData(EmpMap, executorService);
        executorService.shutdown();
        return;
    }


    //Statistic Method Implementaion
    @Override
    public long getEmployeeCountAgeGreaterThan(Predicate<Employee> condition) {
        return EmpMap.values().stream().filter(condition).count();
    }

    @Override
    public List<Integer> getEmployeeIdsAgeGreaterThan(int age) {
        return EmpMap.values()
                .stream()
                .filter(employee -> employee.getAge() > age)
                .map(p -> p.getEmpid()).collect(Collectors.toList());
    }

    @Override
    public Map<String, Long> getEmployeeCountByDepartment() {
        return EmpMap.values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }

    @Override
    public Map<String, Long> getEmployeeCountByDepartmentOrdered() {
        return EmpMap.values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.counting()));
    }

    @Override
    public Map<String, Double> getAvgEmployeeAgeByDept() {
        return EmpMap.values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getAge)));
    }

    @Override
    public List<String> getDepartmentsHaveEmployeesMoreThan(int criteria) {
        return EmpMap.values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > criteria)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getEmployeeNamesStartsWith(String prefix) {
        return EmpMap.values()
                .stream()
                .map(Employee::getName)
                .filter(name -> name.startsWith(prefix))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Double> getAvgEmployeeServiceByDept() {
        return EmpMap.values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(employees -> {
                    Period period = Period.between(employees.getDateofjoining(), LocalDate.now());
                    return period.getYears();
                })));
    }
}



