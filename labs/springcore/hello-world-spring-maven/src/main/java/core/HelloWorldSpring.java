package core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldSpring {
    public static void main(String[] args) {
       /* System.out.println("Hello Spring");
        Greetings greetings=new Greetings();
        System.out.println(greetings.getMessage());
        greetings.setMessage("Hello Spring");
        System.out.println(greetings.getMessage());*/

        //Step1 : create instance of IOC container
        ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-config.xml");
        //ApplicationContext ctx=new FileSystemXmlApplicationContext();

        System.out.println(ctx);
        System.out.println("No.of beans" +ctx.getBeanDefinitionCount());

        Greetings greetings=ctx.getBean("greetings",Greetings.class);
        System.out.println(greetings.getMessage());

        Greetings greetings1=ctx.getBean("greetings1",Greetings.class);
        System.out.println(greetings1.getMessage());

        Greetings greetings2=ctx.getBean("greetings2",Greetings.class);
        System.out.println(greetings2.getMessage());

    }
}
