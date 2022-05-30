package Day4;

class Parent {

    public Parent() {
        System.out.println("Parent Constructor");
    }
    public Parent(int a)
    {
        System.out.println(a);
    }

    public void ParentMethod() {
        System.out.println("Am in Parent Method");
    }
}

class Child extends Parent {
    public Child (){
        System.out.println("Child Constructor");
    }
    public Child(int a)
    {
        super(a);
    }
    public void ChildMethod()
    {
        System.out.println("Am in Child Method");
    }

}

public class Demo2 {
    public static void main(String[] args) {
       Parent p=new Parent();
        p.ParentMethod();
        Child c=new Child(100);
        c.ChildMethod();
        c.ParentMethod();

    }
}
