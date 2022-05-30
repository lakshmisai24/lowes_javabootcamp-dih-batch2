package Day6;

public class Demo6 {
    public static void main(String[] args) {
        System.out.println("Performance Test");
        long startTime=System.currentTimeMillis();

        StringBuffer stringbuffer=new StringBuffer("Hello");
        for(int i=0;i<100000;i++)
        {
            stringbuffer.append("World");
        }
        System.out.println("Time taken by String Buffer is "+(System.currentTimeMillis()-startTime));;

        startTime=System.currentTimeMillis();
        StringBuilder stringbuilder=new StringBuilder("Hello");
        for(int i=0;i<100000;i++)
        {
            stringbuilder.append("World");
        }
        System.out.println("Time taken by String Builder is "+(System.currentTimeMillis()-startTime));


    }
}
