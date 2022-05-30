package com.empapp;

import com.empapp.exception.InputException;
import com.empapp.model.Employee;
import com.empapp.service.EmployeeService;
import com.empapp.service.EmployeeServiceImplemenatation;

import java.util.Scanner;

public class EmployeeManagementMain extends InputException {
    public static void main(String[] args) throws InputException {
        EmployeeService eser = new EmployeeServiceImplemenatation();

        int id, sal, age, size;
        String text = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no.of records for Employee Details :");
        size = sc.nextInt();
        Employee[] emp1 = new Employee[size];
        String ename, designation, department, country;

        do {
            System.out.println("Welcome To Employee Management App" + '\n' +
                    "1.Add Employee" + '\n' + "2.View Employee" + '\n' + "3.Update Employee" + '\n' + "4.Delete Employee" + '\n' + "5.View All Employees" + '\n' + "Select Any Option");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    try {

                        for (int i = 0; i < emp1.length; i++) {
                            System.out.print("Enter employee name : ");
                            ename = sc.next();
                            System.out.print("Enter employee  Id : ");
                            id = sc.nextInt();
                            System.out.print("Enter employee  Age : ");
                            age = sc.nextInt();
                            System.out.print("Enter employee Designation : ");
                            designation = sc.next();
                            System.out.print("Enter employee Department : ");
                            department = sc.next();
                            System.out.print("Enter employee  Country : ");
                            country = sc.next();
                            System.out.print("Enter employee sal : ");
                            sal = sc.nextInt();
                            emp1[i] = new Employee(id, ename, age, designation, department, country, sal);
                        }
                    } catch (InputException in) {
                        throw new InputException();
                    }
                    eser.createEmployee(emp1);
                    break;
                case 2:
                    System.out.println("Enter Employee Id");
                    id = sc.nextInt();
                    eser.viewEmployee(id, emp1);
                    break;
                case 3:
                    System.out.println("Enter Employee Id");
                    id = sc.nextInt();
                    try {
                        for (int i = 0; i < emp1.length; i++) {
                            if (emp1[i].getEmpid() == id) {
                                System.out.println("Enter employee name");
                                ename = sc.next();
                                System.out.println("Enter employee  Age");
                                age = sc.nextInt();
                                System.out.println("Enter employee Designation");
                                designation = sc.next();
                                System.out.println("Enter employee Department");
                                department = sc.next();
                                System.out.println("Enter employee  Country");
                                country = sc.next();
                                System.out.println("Enter employee sal ");
                                sal = sc.nextInt();

                                emp1[i] = new Employee(id, ename, age, designation, department, country, sal);
                            }
                        }
                    }
                    catch (InputException i) {
                        System.out.println(i.getMessage());
                    }

                    eser.updateEmployee(id, emp1);
                    break;
                case 4:
                    System.out.println("Enter Employee Id");
                    id = sc.nextInt();
                    eser.deleteEmployee(id, emp1);
                    break;
                case 5:
                    eser.viewAllEmployees(emp1);
                    break;
                default:
                    System.out.println("Select other option");
            }
            System.out.println("Do u want to continue :Y/N");
            text = sc.next();
        }
        while (text.equalsIgnoreCase("y"));
    }
}





