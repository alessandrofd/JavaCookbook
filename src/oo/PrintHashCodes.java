package oo;

import java.awt.*;

/**
 * Created by Alessandro.Dantas on 24/03/2014.
 */
public class PrintHashCodes {
    /** Some objects to hashCode() on */
    protected static Object[] data = {
            new PrintHashCodes(),
            new Color(0x44, 0x88, 0xcc),
            new SomeClass()
    };

    public static void main(String[] args) {
        System.out.println("About to hashCode " + data.length + " objects.");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i].toString() + " --> " + data[i].hashCode());
        }
        System.out.println("All done.");
    }
}
