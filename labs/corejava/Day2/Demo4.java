package Day2;

public class Demo4 {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        System.out.println(a);  // 10
        System.out.println(b); // 20

        System.out.println(a++); // 10
        System.out.println(a); // 11
        System.out.println(++b); // 21

        //a++
        a = a + 1;

        a += 5;
        // a = a + 5
        System.out.println(a);
    }
}
