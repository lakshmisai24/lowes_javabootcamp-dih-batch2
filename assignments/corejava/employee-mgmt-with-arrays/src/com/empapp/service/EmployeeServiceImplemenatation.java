package com.empapp.service;

import com.empapp.model.Employee;

import java.util.Arrays;
import java.util.InputMismatchException;

public class EmployeeServiceImplemenatation implements EmployeeService {


    @Override
    public void createEmployee(Employee[] e) {

        for (int i = 0; i < e.length; i++) {
            e[i].setEmpid();
            e[i].setName();
            e[i].setAge();
            e[i].setSalary();
            e[i].setCountry();
            e[i].setDepartment();
            e[i].setDesignation();
        }


        System.out.println("Employee Details Added");
    }


    @Override
    public void viewEmployee(int employeeid, Employee[] e) {
        System.out.println("Emp ID \t Name \t Age \t Designation \t Department \t Country \t Salary ");
        for (int i = 0; i < e.length; i++) {
            if (e[i] != null) {
                if (employeeid == e[i].getEmpid()) {
                    System.out.printf("%d     \t      %s     \t      %d     \t     %s      \t     %s     \t      %s     \t     %d \n ", e[i].getEmpid(), e[i].getName(),
                            e[i].getAge(), e[i].getDesignation(), e[i].getDepartment(), e[i].getCountry(), e[i].getSalary());
                }
            }
        }
    }

    @Override
    public void updateEmployee(int employeeid, Employee[] e) throws InputMismatchException {
        for (int i = 0; i < e.length; i++) {
            if (e[i] != null && employeeid == e[i].getEmpid()) {
                e[i].setEmpid();
                e[i].setName();
                e[i].setAge();
                e[i].setSalary();
                e[i].setCountry();
                e[i].setDepartment();
                e[i].setDesignation();
            }
        }
        System.out.println("Employee Details Updated");
    }


    @Override
    public void deleteEmployee(int employeeid, Employee[] e) {
        for (int i = 0; i < e.length; i++) {
            if (e[i] != null) {
                if (employeeid == e[i].getEmpid()) {
                    e[i] = null;
                }

            }
        }
        System.out.println("Employee Deleted");
    }

    @Override
    public void viewAllEmployees(Employee[] e) {
        System.out.println("Emp ID \t Name \t Age \t Designation \t Department \t Country \t Salary ");
        for (int i = 0; i < e.length; i++) {
            if (e[i] != null) {
                System.out.printf("%d  \t   %s   \t   %d  \t   %s  \t   %s  \t   %s  \t    %d \n ",
                        e[i].getEmpid(), e[i].getName(),
                        e[i].getAge(), e[i].getDesignation(),
                        e[i].getDepartment(), e[i].getCountry(), e[i].getSalary());
            }
        }

    }
}

