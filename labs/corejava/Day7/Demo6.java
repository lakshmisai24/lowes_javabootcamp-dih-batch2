package Day7;

public class Demo6 {
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        System.out.println("print original array");
        for(int i:arr)
            System.out.println(i);
        int newArr[]=arr.clone();
        System.out.println("print new array");

        for(int i:newArr)
            System.out.println(i);

        System.out.println(arr==newArr);
    }
}
