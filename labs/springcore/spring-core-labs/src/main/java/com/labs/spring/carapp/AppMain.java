package com.labs.spring.carapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Arrays;

public class AppMain {
    public static void main(String[] args) {
        AbstractApplicationContext ctx=new AnnotationConfigApplicationContext(ApplicationConfig.class);
        System.out.println("No.of beans :"+ctx.getBeanDefinitionCount());
        for(String beanName:ctx.getBeanDefinitionNames()) {
            System.out.println(beanName);
            if(Arrays.asList("bmw","nexon").contains(beanName))
            {
                Car car=ctx.getBean(beanName,Car.class);
                System.out.println(car.getModel()+" " +car.getManufacturer()+car.getColor()+car.getEngine());
            }


        }

        Car bmw=ctx.getBean("bmw",Car.class);
        System.out.println(bmw.getEngine()+" "+bmw.getManufacturer()+" "+bmw.getColor()+" "+bmw.getModel());
//ShutsDows context
        ctx.registerShutdownHook();
    }
}
