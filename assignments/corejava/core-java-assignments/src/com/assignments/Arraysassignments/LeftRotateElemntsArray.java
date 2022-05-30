package Arraysassignments;

public class LeftRotateElemntsArray {
    public static void main(String[] args) {
        int[] numarray = new int[]{2, 5, 6, 7, 9};
        System.out.println("Original Array :");
        for(int x:numarray)
            System.out.println(x);
        int n = 1;
        for (int i = 0; i < n; i++) {
            int first, j;
            first = numarray[0];
            for (j = 0; j < numarray.length - 1; j++) {
                numarray[j] = numarray[j + 1];
            }
            numarray[j] = first;

        }
        System.out.println("Array After Rotating left :");
        for (int x : numarray)
            System.out.println(x);

    }
}
