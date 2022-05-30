package Arraysassignments;

import java.util.Arrays;

public class AddTwoMatrices {
    public static void main(String[] args) {
        int[][] numArray1=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] numArray2=new int[][]{{30,40,50},{70,80,90},{77,42,55}};
        int[][] numArray3=new int[numArray1.length][numArray2.length];

        for(int i=0;i< numArray1.length;i++)
        {
            for(int j=0;j<numArray2.length;j++)
            {
                numArray3[i][j]=numArray1[i][j]+numArray2[i][j];
            }
        }
        System.out.println(Arrays.deepToString(numArray3) + "  ");


    }
}
