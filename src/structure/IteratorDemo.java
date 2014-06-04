package structure;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Alessandro.Dantas on 19/03/2014.
 */
public class IteratorDemo {
    public static void main(String[] args) {
        List<Date> l = new ArrayList<>();
        StructureDemo source = new StructureDemo(15);

        // Add lots of elements to the list...
        l.add(source.getDate());
        l.add(source.getDate());
        l.add(source.getDate());

        int i = 0;

        Iterator it = l.iterator();

        // Process the data structure using an iterator. This part of the code does not know or care if the data is an
        // array, a List, a Vector, or whatever.
        while (it.hasNext()) {
            Object o = it.next();
            System.out.println("Element " + i++ + " = " + o);
        }
    }
}
