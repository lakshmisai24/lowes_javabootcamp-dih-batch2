package Arraysassignments;

public class FindFrequencyEleArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 3, 3, 4, 4, 4, 4, 8, 8, 8, 8, 8};
        int[] arr1 = new int[arr.length];
        int visited = -1;
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    arr1[j] = visited;
                }
            }
            if (arr1[i] != visited)
                arr1[i] = count;
        }
            System.out.println("Element | Frequency");
            for(int x=0;x<arr1.length;x++)
            {
                if(arr1[x]!=visited)
                {
                    System.out.println("  "+arr[x]+"     |     "+arr1[x]);
                }
            }


    }
}
