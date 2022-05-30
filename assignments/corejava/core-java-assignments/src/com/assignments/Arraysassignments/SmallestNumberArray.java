package Arraysassignments;

public class SmallestNumberArray {
    public static void main(String[] args) {
        int[] num=new int[]{10,40,67,43,22};
        int swap;
        for(int i=0;i<num.length;i++)
        {
            for(int j=i+1;j<num.length;j++)
            {
                if(num[i]>num[j])
                {
                    swap=num[i];
                    num[i]=num[j];
                    num[j]=swap;
                }
            }
        }
        System.out.println("Array sorted in ascending order :");
        for(int x:num) {
            System.out.println(x);
        }
        System.out.println("Smallest Element in Array is :"+num[0]);

    }
}
