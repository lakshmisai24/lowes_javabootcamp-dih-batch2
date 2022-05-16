package Lowes_Assignments.Day2Assign;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Any Number");
        n=sc.nextInt();
        System.out.println("Multiplication Table of "+n+ " : ");
        for(int i=1;i<=n;i++)
        {
            System.out.println(n+" X "+i+" = "+i*n);
        }
    }
}
