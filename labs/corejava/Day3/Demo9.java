package Day3;

class Car
{
    public String brand;
    public String year;
    public String model;
    public String color;
    public String engineType;
    public int Price;

    public Car(String brand,String year,String model,String color,String engineType,int Price)
    {
        this.brand=brand;
        this.year=year;
        this.model=model;
        this.color=color;
        this.engineType=engineType;
        this.Price=Price;
    }
    public Car(Car  car)
    {
        this.brand=car.brand;
        this.year=car.year;
        this.model=car.model;
        this.color=car.color;
        this.engineType=car.engineType;
        this.Price=car.Price;
    }
}
public class Demo9 {
    public static void main(String[] args) {
        Car car1=new Car("Audi","1989","Auto","white","full speed",3000000);
        Car car2=new Car(car1.brand,car1.year,car1.model,car1.color,car1.engineType,car1.Price);
    }
}
