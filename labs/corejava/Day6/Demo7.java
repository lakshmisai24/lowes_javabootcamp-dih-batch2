package Day6;

public class Demo7 {
    public static void main(String[] args) {
        int a[]=new int[3];
        a[0]=10;//initialization
        a[1]=20;
        a[2]=30;
       // a[3]=40;//index bounds of array

        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);

        for(int num:a)
            System.out.println(num);



    }
}
