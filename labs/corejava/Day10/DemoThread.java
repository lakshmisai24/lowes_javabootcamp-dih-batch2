package Day10;

public class DemoThread extends Thread{
    public void run()
    {
        System.out.println("Thread Name: "+Thread.currentThread().getName());
        //DemoThread t1=new DemoThread();
        //t1.start();
    }
}
