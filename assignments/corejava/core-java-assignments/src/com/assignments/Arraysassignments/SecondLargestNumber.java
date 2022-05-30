package Arraysassignments;

public class SecondLargestNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{23, 4, 588, 648, 65};
        int swap;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    swap = arr[i];
                    arr[i] = arr[j];
                    arr[j] = swap;
                }
            }
        }
        System.out.println("Second Largest number in an Array :"+arr[arr.length-4]);

    }

}
