package com.emp.service;

import com.employee.exception.AgeHandleException;
import com.employeecollections.model.Employee;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EmployeeServiceImple  implements EmployeeService {

    Map<Integer, Employee> EmpMap = new HashMap<>();

    //Initialise Employee Map With Data
    public  EmployeeServiceImple() {
        EmpMap.put(1, new Employee(1, "Anil", 45, "Delivery Manager", "Operations", "India", 46000));
        EmpMap.put(2, new Employee(2, "Kiran", 35, "Quality Analyst", "Quality", "India", 50000));
        EmpMap.put(3, new Employee(3, "Hari", 42, "Manager", "Operations", "USA", 250000));
        EmpMap.put(4, new Employee(4, "Swapna", 26, "Associate", "Operations", "UK", 60000));
        EmpMap.put(5, new Employee(5, "Baobby", 30, "Lead Associate", "Quality", "India", 47000));

    }

    public int createEmpid() {
        int eid = EmpMap.size() + 1;
        return eid;
    }

    @Override
    public void createEmployee(int id, Employee E) {
        try {
            int age1=CheckAge(E.getAge());
        } catch (AgeHandleException e) {
            throw new RuntimeException(e);
        }

        EmpMap.put(id, E);
        System.out.println("Employee Created Successfully");
    }

    @Override
    public void viewEmployee(int id) {
        boolean found = false;

        Iterator<Employee> it = EmpMap.values().iterator();
        while (it.hasNext()) {
            Employee e = it.next();
            if (e.getEmpid() == id) {
                System.out.println("Emp ID \t Name \t Age \t Designation \t Department \t Country \t Salary ");
                System.out.println(e.getEmpid()+"  "+e.getName()+"  "+e.getAge()+"  " +e.getDesignation()+"  "+
                        e.getDepartment()+"  "+e.getCountry()+"  "+e.getSalary());
                found = true;
            }
        }
        if (!found)
            System.out.println("Employee record not found ");
    }

    @Override
    public void updateEmployee(int id, Employee E1) {
        Iterator<Employee> it = EmpMap.values().iterator();
        while (it.hasNext()) {
            Employee Eit = it.next();
            if (Eit.getEmpid() == id) {
                EmpMap.put(id, E1);
            }
        }
        System.out.println("Employee Details Updated Successfully");
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
        System.out.println("Emp ID \t Name \t Age \t Designation   \t Department    \t Country   \t Salary ");
        Iterator<Employee> it = EmpMap.values().iterator();
        while (it.hasNext()) {
            Employee e = it.next();
            System.out.printf("%d   \t %s   \t%d  \t%s   \t%s   \t %s     \t %d  \n ", e.getEmpid(), e.getName(),
                    e.getAge(), e.getDesignation(), e.getDepartment(), e.getCountry(), e.getSalary());
        }
    }

    public int CheckAge(int x) throws AgeHandleException {
        if(x<18 || x>60)
            throw new AgeHandleException();
        else
        return x;
    }

}


