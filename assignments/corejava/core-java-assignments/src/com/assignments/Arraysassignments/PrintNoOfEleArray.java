package Arraysassignments;

public class PrintNoOfEleArray {
    public static void main(String[] args) {
        int[] num=new int[]{1,2,3,4,5};
        int count=0;
        for(int i=0;i<num.length;i++)
        {
            if(num[i]!=0)
                count++;
        }
        System.out.println("No.of Elements in array is "+count);
        //Find no.of elements using array length
       // System.out.println("no.of elements in an array "+num.length);
    }
}
