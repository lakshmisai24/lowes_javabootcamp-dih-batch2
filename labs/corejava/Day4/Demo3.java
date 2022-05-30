package Day4;
//class A//simple inheritance
//{
//    public void Test1(){}
//}
//class B extends A{
//    public void Test2()
//    {
//
//    }
//}

class A//Multilevel Inheritance
{
    public void test1() {
    }
}

class B extends A {
    public void test2() {

    }
}

class C extends B {
    public void test3() {

    }
}


//hierarchial inheritance

public class Demo3 {
    public static void main(String[] args) {
        A a = new A();
        a.test1();

        B b = new B();
        b.test1();
        b.test2();

        C c = new C();
        c.test1();
        c.test2();
        c.test3();
    }
}
