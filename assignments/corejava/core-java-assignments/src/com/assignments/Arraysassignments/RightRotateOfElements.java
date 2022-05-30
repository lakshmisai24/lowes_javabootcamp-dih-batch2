package Arraysassignments;

public class RightRotateOfElements {
    public static void main(String[] args) {
        int[] numarray = new int[]{2, 5, 6, 7, 9};
        System.out.println("Original Array :");
        for(int x:numarray)
            System.out.println(x);
        int n = 1;
        for (int i = 0; i < n; i++) {
            int last, j;
            last = numarray[numarray.length-1];
            for (j = numarray.length-1;j>0; j--) {
                numarray[j] = numarray[j - 1];
            }
            numarray[0] = last;

        }
        System.out.println("Array After Rotating Right :");
        for (int x : numarray)
            System.out.println(x);

    }
    }

