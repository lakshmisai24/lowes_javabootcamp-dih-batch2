package Lowes_Assignments.Day2Assign;

public class MultiplicationTenRevOrder {
    public static void main(String[] args) {
        int n=10;
        System.out.println("Multiplication Table of 10 in Reverse Order : ");
        for(int i=10;i<=n;i--)
        {
            System.out.println(n+" X " +i+" = "+n*i);
            if(i==1)
                break;
        }
    }
}
