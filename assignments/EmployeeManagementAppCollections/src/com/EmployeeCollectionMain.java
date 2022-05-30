package com;

import com.emp.service.EmployeeServiceImple;
import com.employeecollections.model.Employee;

import java.util.Scanner;

public class EmployeeCollectionMain {

    public static void main(String[] args) {
        int id, sal, age;
        String text = "";
        Scanner sc = new Scanner(System.in);
        String ename, designation, department, country;
        EmployeeServiceImple eser = new EmployeeServiceImple();
        do {
            System.out.println("Welcome To Employee Management App" + '\n' +
                    "1.Add Employee" + '\n' + "2.View Employee" + '\n' + "3.Update Employee" + '\n' +
                    "4.Delete Employee" + '\n' + "5.View All Employees" +'\n'+"6.Exit"+ '\n' + "Select Any Option");
            int option = sc.nextInt();
            switch (option) {
                case 1:

                    System.out.print("Enter Employee name : ");
                     ename = sc.next();
                    //Generating Employee Id in service based Employee size
                    id = eser.createEmpid();
                    System.out.print("Enter Employee  Age : ");
                    age = sc.nextInt();
                    System.out.print("Enter Employee Designation : ");
                    designation = sc.next();
                    System.out.print("Enter Employee Department : ");
                    department = sc.next();
                    System.out.print("Enter Employee  Country : ");
                    country = sc.next();
                    System.out.print("Enter Employee Sal : ");
                    sal = sc.nextInt();
                    Employee e = new Employee(id, ename, age, designation, department, country, sal);
                    //Calling Service to Call Employee
                    eser.createEmployee(id, e);

                    break;
                case 2:
                    System.out.println("Enter Employee Id");
                    id = sc.nextInt();
                    eser.viewEmployee(id);

                    break;
                case 3:
                    System.out.println("Enter Employee Id to Update");
                    id = sc.nextInt();

                    System.out.println("Enter Updated Employee Name");
                    ename = sc.next();
                    System.out.println("Enter Updated Employee  Age");
                    age = sc.nextInt();
                    System.out.println("Enter Updated Employee Designation");
                    designation = sc.next();
                    System.out.println("Enter Updated Employee Department");
                    department = sc.next();
                    System.out.println("Enter Updated Employee  Country");
                    country = sc.next();
                    System.out.println("Enter Updated Employee Sal ");
                    sal = sc.nextInt();
                    Employee e1 = new Employee(id, ename, age, designation, department, country, sal);
                     eser.updateEmployee(id,e1);
                    break;
                case 4:
                    System.out.println("Enter Employee Id");
                    id = sc.nextInt();
                    eser.deleteEmployee(id);
                    break;
                case 5:
                    eser.viewAllEmployees();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Select other option");
            }
            System.out.println("Do u want to continue :Y/N");
            text = sc.next();
        }
        while (text.equalsIgnoreCase("y"));
    }

}

