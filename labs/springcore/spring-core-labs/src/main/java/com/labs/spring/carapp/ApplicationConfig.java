package com.labs.spring.carapp;


import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
public class ApplicationConfig {


    @Bean
    @Lazy(value = false)
    @Scope("singleton")
    public Car bmw() {
        // return new Car("xt","BMW" ,"White",petrol());

        //setter injection
        Car bmw = new Car("xt", "BMW", "wHITE");
        bmw.setEngine(electric());
        bmw.setColor("Red");
        bmw.setManufacturer("BMW");
        return bmw;

    }

    @Bean
    public Car Nexon() {
        Car bmw = new Car("xt", "BMW", "wHITE");
        bmw.setEngine(petrol());
        return bmw;
    }


    @Bean

    public Engine petrol() {
        return new Engine("petrol", 2000);
    }

    @Bean
    public Engine diesel() {
        return new Engine("petrol", 3000);
    }

    //@Bean(autowireCandidate = false)
    public Engine electric() {
        return new Engine("petrol", 4000);

    }
}
