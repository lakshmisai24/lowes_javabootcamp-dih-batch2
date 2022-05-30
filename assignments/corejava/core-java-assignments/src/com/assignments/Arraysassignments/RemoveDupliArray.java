package Arraysassignments;

public class RemoveDupliArray {
    public static void main(String[] args) {
        int[] array1 = new int[]{5,6,5,7,11,5,6};
        int[] array2 = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            for (int j = i + 1; j < array1.length; j++) {
                if (array1[i] == array1[j]) {
                    array1[j] = 0;
                }
            }

        }
        System.out.println("Removing duplicate elements from an array");
        for (int x = 0; x < array1.length; x++) {
            if (array1[x] == 0)
                continue;
            else
                array2[x] = array1[x];
            System.out.println(array2[x]);
        }
    }

}
