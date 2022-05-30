package Arraysassignments;

public class PrintLargestElmArray {
    public static void main(String[] args) {
        int[] num=new int[]{99,45,32,8,54};
        int swp;
        for(int i=0;i< num.length;i++)
        {
            for(int j=i+1;j< num.length;j++)
            {
                if(num[i]>num[j])
                {
                    swp=num[i];
                    num[i]=num[j];
                    num[j]=swp;
                }
            }
        }
        System.out.println("Array sorted in ascending order :");
        for(int x:num) {
            System.out.println(x);
        }
        System.out.println("Largest Element in Array is :"+num[num.length-1]);
    }

}
