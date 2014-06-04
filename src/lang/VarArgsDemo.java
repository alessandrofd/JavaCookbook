package lang;

import java.io.PrintStream;
import java.util.Date;

/**
 * Created by Alessandro on 21/04/2014.
 */
public class VarArgsDemo {
    public static void main(String[] args) {
        mySumCall();

        process(System.out, "Hello", "Goodbye");
        process(System.out, (int)42, (int)1066, (int)1766);
        process(System.out, "Foo", new Date(), new Object());

        passThrough(System.out, "%s %s %s%n", "Foo", new Date(), new Object());
    }

    static int mySum(int ... args) {
        int total = 0;
        for (int a : args)
            total += a;
        return total;
    }

    public static void mySumCall() {
        System.out.println(mySum(5, 7, 9));
        System.out.println(mySum(5));
        System.out.println(mySum());
        int[] nums = { 5, 7, 9 };
        System.out.println(mySum(nums));
    }

    static void passThrough(PrintStream out, String fmt, Object ... args) {
        line();
        out.printf(fmt, args);
    }

    static void process(PrintStream out, Object ... args ) {
        line();
        int i = 0;
        for (Object o : args)
            out.print("Argument " + ++i + " is " + o + "; ");
        System.out.println();
    }

    private static void line() {
        System.out.println("----------------------------------");
    }
}
