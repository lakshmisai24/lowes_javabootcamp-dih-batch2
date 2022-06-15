package com.employee.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table
public class Employee {
	
		@Id
		@GeneratedValue
	 	 private int empid;
	 	

	 	@NotBlank(message = "Name cannot be empty")
	    private String name;
	    
	    
	 	@NotNull(message="Age is required")
	    @Min(value=18, message="Minimum Age must be 18")
	 	@Max(value=60, message="Maximum Age must be 60")
	    private int age;
	   
	 	 @NotEmpty(message=" Designation cannot be Blank")
	    private String designation;
	   
	 	@NotEmpty(message=" Department cannot be Blank")
	    private String department;
	    
	 	@NotEmpty(message=" Country cannot be Blank")
	    private String country;
	    
	 	@NotNull(message=" Salary cannot be empty")
	    @Min(value=8000, message="Minimum amount for salary is 8000")
	    private int salary;
	    
	    
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
}
