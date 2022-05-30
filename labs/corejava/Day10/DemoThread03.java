package Day10;

import java.util.concurrent.Callable;

public class DemoThread03 implements Callable<String> {
    @Override
    public String call() throws Exception {
        for(int i=0;i<100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        return Thread.currentThread().getName()+"Thread Execution Completed";
    }
}
