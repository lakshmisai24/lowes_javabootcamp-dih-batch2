package Arraysassignments;

public class PrintEvenPosElem {
    public static void main(String[] args) {
        int[] num=new int[]{1,2,3,4,5,6,7,8,9,10};
        for(int i=0;i< num.length;i=i+2)
            System.out.println(num[i]);
    }
}
