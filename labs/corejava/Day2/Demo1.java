package Day2;
class Demo{
    static int z = 100; // static variable
    int x = 10;  // instance variable

    public void addNumber(){
        // static int d = 100; not allowed
        int a = 10;  // local variable
        int b = 20;
    }

    public void foo(){

    }
}

public class Demo1 {
    public static void main(String[] args) {
        Demo obj = new Demo();
        obj.addNumber();


    }
}



