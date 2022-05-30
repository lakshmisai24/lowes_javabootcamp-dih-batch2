package Day6;

public class Demo4 {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();
        System.out.println(sb.capacity());
        sb.append("Hello");
        System.out.println(sb.capacity());
        sb.append("Welcome to Java Class");
        System.out.println(sb.capacity());

        /* (old capacity *2)+2

        default=16

        * */
    }
}
