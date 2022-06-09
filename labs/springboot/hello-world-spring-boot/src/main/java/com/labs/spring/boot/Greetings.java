package com.labs.spring.boot;

import org.springframework.stereotype.Component;

//@Component
public class Greetings {

    String message="Welcome to spring boot learning";
    public Greetings()
    {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
