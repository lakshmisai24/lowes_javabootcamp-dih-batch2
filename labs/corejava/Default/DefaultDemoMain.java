package Default;

import com.sun.jdi.PathSearchingVirtualMachine;
import jdk.swing.interop.SwingInterOpUtils;

public class DefaultDemoMain {
    public static void main(String[] args) {
        DefaultDemo.staticPrint();
        DefaultDemoImpl.staticPrint();

        DefaultDemoImpl obj1=new DefaultDemoImpl();
        obj1.defaultPrinting();

        DefaultDemoImpl obj2=new DefaultDemoImpl();
        obj2.defaultPrinting();

        System.out.println(DefaultDemo.message);



    }


}
