package com.labs.spring.carapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Car {

    String model;
    String manufacturer;
    String color;

    @Autowired
    @Qualifier("petrol")
    Engine engine;


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getColor() {
        return color;
    }

    public Car() {
    }

    public Car(String model, String manufacturer, String color, Engine engine) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.color = color;
        this.engine = engine;
    }

    public Car(String model, String manufacturer, String color) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.color = color;
    }

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void init(){
        System.out.println("Car bean inintialised");
    }
}
