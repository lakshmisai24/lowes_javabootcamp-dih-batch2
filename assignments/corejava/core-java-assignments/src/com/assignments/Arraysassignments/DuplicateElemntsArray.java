package Arraysassignments;

public class DuplicateElemntsArray {
    public static void main(String[] args) {
        int[] orgarr = new int[]{1, 2, 2, 3, 4, 5, 5};
        System.out.println("Duplicate elements of an array are");
        for (int i = 0; i < orgarr.length; i++) {
            int count = 0;
            for (int j = i + 1; j < orgarr.length; j++) {
                if (orgarr[i] == orgarr[j]) {
                    System.out.println(orgarr[i]);
                }
            }
        }
    }
}


