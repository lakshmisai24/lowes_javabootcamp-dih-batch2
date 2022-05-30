package Arraysassignments;

public class CopyElementsArray {
    public static void main(String[] args) {
        int[] number = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Elements of original array");
        for (int x : number)
            System.out.println(x);
        int[] number1 = new int[number.length];
        for (int i = 0; i < number.length; i++) {
            number1[i] = number[i];
        }
        System.out.println("Elements of New array");
        for (int i : number1)
            System.out.println(i);
    }
}
