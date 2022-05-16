package Lowes_Assignments.Day2Assign;

import java.util.Scanner;

public class SumOfFirstnEvenNumbers {
    public static void main(String[] args) {
        int n,num=1;
        int i=0,sum=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter any number");
        n=sc.nextInt();
        while(i<n)
        {
            if(num%2==0) {
                sum = num + sum;
                i++;
            }
            num++;
        }

        System.out.println("Sum of First n Even numbers is " + sum);
    }
}
