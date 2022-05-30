package Day4;

class A10
{
    int a=10;
    static {
        System.out.println("Static Block");
    }
}
public class Demo7 {
    public static void main(String[] args) {
        A10 aa=new A10();
        System.out.println("Main method");
    }
}
