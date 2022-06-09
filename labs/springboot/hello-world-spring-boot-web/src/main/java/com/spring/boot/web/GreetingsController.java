package com.spring.boot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
	
	@GetMapping("/greetings")
    public String greetings() {
        return "Welcome to Spring Boot Web App demo";

}
}