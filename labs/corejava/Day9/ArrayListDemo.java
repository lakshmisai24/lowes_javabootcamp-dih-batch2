package Day9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListDemo {
    public static void main(String[] args) {

        //Array list of raw type
        ArrayList arrlist=new ArrayList();
        arrlist.add(10);
        arrlist.add("list");
        arrlist.add(30);

        //Display the elements in the ArrayList
        for (Object item:arrlist) {
            System.out.println(item);
        }
//remove element
        arrlist.remove(2);
        System.out.println("After removal");
        for(Object item:arrlist)
            System.out.println(item);

        //update element
        arrlist.set(2,100);
        System.out.println("After updation");
        for(Object item:arrlist)
            System.out.println(item);

        //ArrayList of generic type
        ArrayList<Integer> aarr=new ArrayList<>();
        aarr.add(10);
        aarr.add(20);
        for(Integer item:aarr)
            System.out.println(item);

        //Iterator usage with generic type...
        Iterator<Integer> iterator1=aarr.iterator();
        while(iterator1.hasNext())
        {
            System.out.println(iterator1.next());
        }

        System.out.println("List iterator usage with generic type");
        ListIterator<Integer> listitera= arrlist.listIterator();
        listitera.hasNext();
        listitera.previous();
        listitera.hasPrevious();

        }




    }


