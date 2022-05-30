package Day2;

public class Demo2 {

    public static void main(String[] args) {

        int a = 30;
        int b = 20;
        int c = 10;
        boolean e = true;
        boolean f = false;

        System.out.println(a + b); // 50
        System.out.println(a - b); // 10
        System.out.println(a * b); // 600
        System.out.println(a / b);

        System.out.println(a > b);
        System.out.println(a > b && a > c); // true
        System.out.println(a > b && a < b); // false
        System.out.println(a > b || a < c);  // true

        int max = (a > b) ? a : b;
        System.out.println(max);


    }
}
