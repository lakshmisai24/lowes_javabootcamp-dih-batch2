package Day4;
class Student{
    int rollnumber;
    String name;
    //stativ variable
    static String schoolname="St Josephs";

}
public class Demo4 {
    public static void main(String[] args) {
     Student std=new Student();
     std.name="hari";
     std.rollnumber=122121;
        System.out.println("Student id"+std.rollnumber+"sTUDENT name"+std.name+Student.schoolname);
    }
}
