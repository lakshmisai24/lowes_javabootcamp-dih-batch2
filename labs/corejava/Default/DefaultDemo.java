package Default;

public interface DefaultDemo {

    public static final String message="Hello Default Interface";


//java 8
    static void staticPrint()
    {
        System.out.println("Static Implementation");
    }
//java 8
    default void defaultPrinting()
    {
        System.out.println("Default Implementation");
    }
    //java 9
    private void print(){
        System.out.println("Private Method Implementation..");
    }

}
