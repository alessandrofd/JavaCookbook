package structure;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Alessandro.Dantas on 19/03/2014.
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Date> al = new ArrayList<>();

        // Create a source of Objects
        StructureDemo source = new StructureDemo(15);

        // Add lots of elements to the ArrayLst...
        al.add(source.getDate());
        al.add(source.getDate());
        al.add(source.getDate());

        // Print them out using a for loop
        System.out.println("Retrieving by index:");
        for (int i = 0; i < al.size(); i++) {
            System.out.println("Element " + i + " = " + al.get(i));
        }
    }
}
