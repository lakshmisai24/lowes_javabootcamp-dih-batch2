package Day3;

class Student
{
    public Student(){
        System.out.println( "default constructor");
    }
    public Student(int a){
        System.out.println("one parameter constructor");
    }
    public Student(String a){
        System.out.println("String parameter");
    }
    public Student(int a ,String b)
    {
        System.out.println("two parameters int ,String");
    }
    public Student(String a ,int b)
    {
        System.out.println("two parameters String,int");
    }
}
public class Demo8 {
    public static void main(String[] args) {
        Student student1=new Student();
        Student student2=new Student(10);
        Student student3=new Student("lakshmi");
        Student student4=new Student(10,"lakshmi");
        Student student5=new Student("lakshmi",10);
    }
}
