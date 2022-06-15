package com.employee.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeMgmtWithSpringbootJpaApplication implements CommandLineRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeMgmtWithSpringbootJpaApplication.class);
	
	@Value("${general.name}")
	private String name;
	
	@Value("${general.applicationName}")
	private String applicationName;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeMgmtWithSpringbootJpaApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
			System.out.println("My Application name: " + applicationName + " :"  + name);
			
			logger.debug("This is DEBUG");
			
	}

}
