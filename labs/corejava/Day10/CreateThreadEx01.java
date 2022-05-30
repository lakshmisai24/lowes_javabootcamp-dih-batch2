package Day10;

public class CreateThreadEx01  {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Thread Name :"+Thread.currentThread().getName());
        DemoThread t1=new DemoThread();
        t1.setName("t1");
        t1.setPriority(10);
        t1.start();//Runnable
        t1.join();//wait till thread to die

        DemoThread t2=new DemoThread();
        t2.setName("t2");
        t2.setPriority(5);
        t2.start();
        t2.join();

        DemoThread t3=new DemoThread();
        t3.setName("t3");
        t3.setPriority(3);
        t3.start();
        t3.join();


    }
}
