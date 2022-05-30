package Day10;

public class CreateThreadEx02 implements Runnable{
    public static void main(String[] args) {
        System.out.println("Thread Name: " + Thread.currentThread().getName());

        DemoThread01 r1 = new DemoThread01();
        Thread t1 = new Thread(r1);
        t1.setName("t1");
        t1.start();

        Thread t2 = new Thread(new DemoThread01());
        t2.setName("t2");
        t2.start();

        Thread t3 = new Thread(new CreateThreadEx02());
        t3.setName("t3");
        t3.start();

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "" + i);
                }
            }
        });
    }






            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+""+i);
                }
            }
    }






