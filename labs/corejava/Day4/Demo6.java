package Day4;
class Calculator{
    //no static method
    public void addNumber(int a,int b)
    {
        System.out.println(a+b);
    }
    //static method
    public static void subNumber(int a,int b)
    {
        System.out.println(a-b);
    }
}
public class Demo6 {
    public static void main(String[] args) {
        Calculator  cal=new Calculator();
        cal.addNumber(10,20);
        Calculator.subNumber(45,23);
    }
}
