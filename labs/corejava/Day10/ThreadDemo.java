package Day10;

public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("Hello Java");

        Thread.currentThread().setName("default");
        Thread.currentThread().setPriority(10);
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().getState().name());
        System.out.println(Thread.currentThread().isDaemon());
    }
}
