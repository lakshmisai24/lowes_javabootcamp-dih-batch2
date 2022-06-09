package service;


import model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Predicate;


@Component
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
