package Lowes_Assignments.Day2Assign;

public class CalSumOfMulTableEight {
    public static void main(String[] args) {
        int n=8,sum=0;
        for(int i=1;i<=n;i++)
        {
           sum=sum+(n*i);
        }
        System.out.println("Sum of the nos occurring in mul table of 8 : "+sum);
    }
}
