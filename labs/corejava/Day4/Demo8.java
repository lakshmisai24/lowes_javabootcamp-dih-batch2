package Day4;

class A5
{
    static int a;
    static {
        a=20;
        System.out.println("static "+a);
    }
    public void Test()
    {
        System.out.println(a);
    }
}
public class Demo8 {
    public static void main(String[] args) {
        A5 aa=new A5();
        aa.Test();
    }
}
//static vaibale can be accesed both in satic method and non ststic methods