package LambdaExpression;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class FunctionalInterfacesDemo {
    public static void main(String[] args) {


        //Consumer ->take arguments no return
        Consumer<String> consumer = (msg) -> System.out.println(msg);
        consumer.accept("Hello Consumer");

        //Supplier->take arguments no return value
        Supplier<List> supplier = () -> Arrays.asList("Java", "Spring", "Hibernate");
        System.out.println(supplier.get());

        //Function ->take argument and return value
        Function<Integer, String> function = (a) -> {
            if (a % 2 == 0) return "even";
            else return "odd";
        };
        System.out.println(function.apply(10));

        //Function->Take argument and return value of same type
        UnaryOperator<Integer> unary = (a) -> a * 2;
        System.out.println(unary.apply(15));

        //Function ->takes two argument and return value of same type
        BinaryOperator<Integer> binary = (a, b) -> (a + b) * 2;
        System.out.println(binary.apply(10, 20));

        //Predicate ->take arguments and return boolean value
        Predicate<Integer> predicate = (age)  ->age > 20;
        System.out.println(predicate.test(10));


    }
}
