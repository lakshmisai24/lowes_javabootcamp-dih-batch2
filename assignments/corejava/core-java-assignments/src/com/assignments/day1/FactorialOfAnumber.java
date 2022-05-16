package Lowes_Assignments.Day2Assign;

import java.util.Scanner;

public class FactorialOfAnumber {
    public static void main(String[] args) {
        int n,fact=1;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Any Number");
        n=sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            fact=fact*i;
        }
        System.out.println("Factorial of "+ n +" is : "+fact);

    }
}
