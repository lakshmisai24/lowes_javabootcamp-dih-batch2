package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import dao.EmployeeDaoService;
import dao.EmployeeDaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


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


    public Employee()
    {

    }
    @Autowired
    EmployeeDaoService Eds;
    @Autowired
    EmployeeDaoServiceImpl edao;

    public EmployeeDaoService getEds() {
        return Eds;
    }

    public void setEds(EmployeeDaoService eds) {
        Eds = eds;
    }

    public EmployeeDaoServiceImpl getEdao() {
        return edao;
    }

    public void setEdao(EmployeeDaoServiceImpl edao) {
        this.edao = edao;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getDateofjoining() {
        return dateofjoining;
    }

    public void setDateofjoining(LocalDate dateofjoining) {
        this.dateofjoining = dateofjoining;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(LocalDateTime modifiedtime) {
        this.modifiedtime = modifiedtime;
    }
}
