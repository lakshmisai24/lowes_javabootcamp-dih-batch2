package Lowes_Assignments.Day2Assign;

import java.util.Scanner;

public class FactorialUsingWhile {
    public static void main(String[] args) {
        int i = 1, n, fact = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Any Number");
        n = sc.nextInt();
        while (i <= n) {
            fact = fact * i;
            i++;
        }
        System.out.println("Factorial of "+ n +" is : "+fact);

    }
}
