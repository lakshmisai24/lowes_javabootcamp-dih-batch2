package com.labs.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@ComponentScan,@Configuration,@EnableAutoConfiguration
@Component
public class HelloWorldSpringBootApplication implements CommandLineRunner {

	@Autowired
	ApplicationContext context;

	public static void main(String[] args) {
		System.out.println("Hello Spring Boot before launch...");
		SpringApplication.run(HelloWorldSpringBootApplication.class, args);
		System.out.println("Hello Spring Boot after launch...");


	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello spring boot during launch");
		System.out.println("Context: "+context);
		System.out.println("No of Beans "+context.getBeanDefinitionCount());

		for(String beanName:context.getBeanDefinitionNames())
			System.out.println(beanName);

		Greetings greetings=context.getBean("greetings",Greetings.class);
		System.out.println(greetings.message);
	}

	//if we dont give @component in grretings we need to define in the class
	@Bean
	public Greetings greetings(){
		return new Greetings();
	}
}
