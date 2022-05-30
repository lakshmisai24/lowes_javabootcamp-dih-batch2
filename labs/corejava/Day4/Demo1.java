package Day4;
class Employee
{
    public String firstname;
    public String lastname;
}
class FullTimeEmployee extends Employee{

}
class PartTimeEmployee extends Employee{
    public int hourSalary;
}
public class Demo1 {
    public static void main(String[] args) {
        FullTimeEmployee fte=new FullTimeEmployee();
        fte.firstname="aaa";
        fte.lastname="bdhd";


        PartTimeEmployee pte=new PartTimeEmployee();
        pte.firstname="nssm";
        pte.lastname="hdhd";
        pte.hourSalary=88939;
    }
}
