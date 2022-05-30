package Day7;

public class Demo12 {
    public static void main(String[] args) {
        //converting all primitive type into wrapper class
        byte a = 10;
        short b = 20;
        int c = 30;
        long d = 40;
        float e = 12.3f;
        double f = 12.23;
        char g = 'c';
        boolean h = true;

        // autoboxing : converting primitive into object
        Byte byteObj = a;
        Short shortObj = b;

        // unboxing : converting object into primitive type
        byte byteValue = byteObj;
        short shortValue = shortObj;


    }
}
