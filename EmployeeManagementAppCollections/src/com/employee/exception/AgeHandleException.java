package com.employee.exception;

public class AgeHandleException extends Exception{
    public AgeHandleException()
    {
        System.out.println("Age Should be between 18 and 60");
    }
}
