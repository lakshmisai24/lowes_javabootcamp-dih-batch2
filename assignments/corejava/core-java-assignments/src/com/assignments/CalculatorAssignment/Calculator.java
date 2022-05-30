package CalculatorAssignment;

import java.util.Scanner;

class CalculatorApp {
    public int result;

    public int Add(int a, int b) {
        result = a + b;
        return result;
    }

    public int Sub(int a, int b) {
        result = a - b;
        return result;
    }

    public int Mul(int a, int b) {
        result = a * b;
        return result;
    }

    public int Div(int a, int b) {
        result = a / b;
        return result;
    }
}


public class Calculator {
    public static void main(String[] args) {
        int option, m, n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Select Option :"+'\n'+"Press 1 : Add" +'\n'+
                "Press 2 : Subtract" +'\n'+
                "Press 3 : Multiply" +'\n'+
                "Press 4 : Divide");
        option = sc.nextInt();
        System.out.println("Enter First Number");
        m = sc.nextInt();
        System.out.println("Enter Second Number");
        n = sc.nextInt();
        CalculatorApp cap = new CalculatorApp();
        switch (option) {
            case 1:
                cap.Add(m, n);
                System.out.println("Result is " + cap.result);
                break;
            case 2:
                cap.Sub(m, n);
                System.out.println("Result is " + cap.result);
                break;
            case 3:
                cap.Mul(m, n);
                System.out.println("Result is " + cap.result);
                break;
            case 4:
                cap.Div(m, n);
                System.out.println("Result is " + cap.result);
                break;
            default:
                System.out.println("This option is not mentioned");

        }


    }

}
