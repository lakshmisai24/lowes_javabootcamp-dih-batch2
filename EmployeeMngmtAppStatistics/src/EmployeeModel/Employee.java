package EmployeeModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee {
    private int empid;
    private String name;
    private int age;
    private String designation;
    private String department;
    private String country;

    private int salary;

    private LocalDate dateofjoining;

    private LocalDateTime createdTime;
    private LocalDateTime modifiedtime;

    public Employee(int empid, String name, int age, String designation, String Department, String Country, int salary,
                    LocalDate dateofjoining, LocalDateTime createdTime, LocalDateTime modifiedtime) {
        this.empid = empid;
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.department = Department;
        this.country = Country;
        this.salary = salary;
        this.dateofjoining = dateofjoining;
        this.createdTime = createdTime;
        this.modifiedtime = modifiedtime;
    }

    public Employee() {

    }


    public String getName() {
        return name;
    }

    public LocalDate getDateofjoining() {
        return dateofjoining;
    }

    public void setDateofjoining() {
        this.dateofjoining = dateofjoining;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime() {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime() {
        this.modifiedtime = modifiedtime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = this.age;
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

    public void setName(String ename) {
        this.name = name;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int id) {
        this.empid = empid;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary() {
        this.salary = salary;
    }


}
