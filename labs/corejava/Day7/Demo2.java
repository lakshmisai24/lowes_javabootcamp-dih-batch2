package Day7;

public class Demo2 {

    static int[] get()
    {
        return new int[]{10,20,30,40};
    }

    public static void main(String[] args) {
        int arr[] =get();
        for(int i=0;i< arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }
}
