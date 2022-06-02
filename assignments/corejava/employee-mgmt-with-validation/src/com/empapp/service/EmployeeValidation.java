package com.empapp.service;

import com.empapp.model.Employee;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class EmployeeValidation {
    public static boolean validate(Employee emp, Predicate<Employee> validator)
    {
        // emp.getAge() >= 20 && emp.getAge() <= 60 && emp.getSalary() > 0
        return validator.test(emp); // executes lambda expression body
    }

    public static void handleError(String errorMessage, Consumer<String> consumer)
    {
        consumer.accept(errorMessage);
    }

}
