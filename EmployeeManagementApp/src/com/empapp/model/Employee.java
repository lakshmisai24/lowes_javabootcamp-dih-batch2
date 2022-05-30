package com.empapp.model;

public class Employee {

    private int empid;
    private  String name;
    private int age;
    private String designation;
    private String department;
    private String country;

    public  int salary;

    public Employee(int empid,String name,int age,String designation,String Department,String Country,int salary)
    {
        this.empid=empid;
        this.name = name;
        this.age=age;
        this.designation=designation;
        this.department=Department;
        this.country=Country;
        this.salary=salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation() {
        designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment() {
        department = department;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry() {
        country = country;
    }

    public void setName() {
        this.name = name;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid() {
        this.empid = empid;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary() {
        this.salary = salary;
    }
}
