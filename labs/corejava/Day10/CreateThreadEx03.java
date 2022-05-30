package Day10;

import java.util.concurrent.*;

public class CreateThreadEx03 implements Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //DemoThread03 c1=new DemoThread03();

        ExecutorService ex= Executors.newFixedThreadPool(5);

        //Approach #1
        DemoThread03 c1=new DemoThread03();
        Future<String> f1=ex.submit(c1);
        //while(f1.isDone())
        //{
          //  String response= f1.get();
            System.out.println(f1.get());
        //}

        //Approach #2
        //ExecutorService exs=Executors.newFixedThreadPool(5);
       // ExecutorService exs=Executors.newSingleThreadExecutor();
        ExecutorService exs=Executors.newCachedThreadPool();
       // ExecutorService exs=Executors.newWorkStealingPool();

        Future<String> f2=  exs.submit(new DemoThread03());
       // while (f2.isDone())
        //{
          //  String response= f2.get();
            System.out.println(f2.get());

            Future<String> f3=exs.submit(new CreateThreadEx03());
        System.out.println(f3.get());

        Future<String> f4=exs.submit(new Callable<String>()
        {

            @Override
            public String call() throws Exception {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread() + " " + i);
                }
                return Thread.currentThread().getName()+" "+"Thread execution completed";
            }
        });

    }




    @Override
    public Object call() throws Exception {
        for(int i=0;i<100;i++)
        {
            System.out.println(Thread.currentThread().getName()+""+i);
        }
        return  Thread.currentThread().getName()+"-Thread Execution Completed";
    }
}

