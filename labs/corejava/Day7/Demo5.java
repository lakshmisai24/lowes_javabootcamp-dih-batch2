package Day7;

public class Demo5 {
    public static void main(String[] args) {
        char[] sourceArray={'a','e','c','d','b'};
        char[] destinationArray=new char[5];

        System.arraycopy(sourceArray,0,destinationArray,0,5);
        System.out.println(String.valueOf(destinationArray));


    }
}
