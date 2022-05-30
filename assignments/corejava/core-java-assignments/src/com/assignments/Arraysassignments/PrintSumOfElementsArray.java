package Arraysassignments;

public class PrintSumOfElementsArray {
    public static void main(String[] args) {
        int[] num=new int[]{2,4,5,8,9,10};
        int count=0;
        for(int i=0;i< num.length;i++)
        {
            count=num[i]+count;
        }
        System.out.println("Sum of Elements of an array :"+count);
    }
}
