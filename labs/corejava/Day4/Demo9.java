package Day4;
class Car
{
    public int speedlimit =50;
    public void drive()
    {
        speedlimit=80;
    }
}
public class Demo9 {
    public static void main(String[] args) {
        Car c =new Car();
        c.speedlimit=90;
        c.drive();
    }
}
