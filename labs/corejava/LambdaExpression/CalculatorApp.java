package LambdaExpression;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class CalculatorApp {
    public static void main(String[] args) {
        //ICalculator add=(a,b) -> {System.out.println(a+b);return a+b;};
        //ICalculator sub=(a,b) -> a - b;
        //ICalculator mul=(a,b) -> a * b;
        //ICalculator div=(a,b) -> a / b;



        //doCalculate(10,20,(a,b)->a+b);

//Functional Interfaces
        BiFunction<Integer,Integer,Integer> add=(a,b)->{System.out.println(a+b);return a+b;};
        BiFunction<Integer,Integer,Integer> sub=(a,b)->{System.out.println(a+b);return a-b;};
        BiFunction<Integer,Integer,Integer> mul=(a,b)->{System.out.println(a+b);return a*b;};
        BiFunction<Integer,Integer,Integer> div=(a,b)->{System.out.println(a+b);return a/b;};

        //System.out.println("20+10 "+doCalculate(20,10,add));
        //System.out.println("20-10 "+doCalculate(20,10,sub));
        //System.out.println("20*10 "+doCalculate(20,10,mul));
       // System.out.println("20/10 "+doCalculate(20,10,div));


    }

    private static int doCalculate(int a ,int b,ICalculator operation)
    {
        return operation.calculate(a,b);
    }

   // public interface Icalculator{
       // public int calculate(int a,int b);
    //}
}
