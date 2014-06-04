package numbers;

/**
 * Created by Alessandro.Dantas on 12/03/14.
 */
public class AutoboxDemo {

    /** Shows autoboxing (in the call to foo(i), i is wrapped automatically)
     * and auto-unboxing (the return value is automatically unwrapped.
     */
    public static void main(String[] args) {
        int i = 42;
        // Autoboxing: int 42 is converted to Integer(42). Also auto-unboxing: the Integer
        // returned from foo() is auto-unboxed to assign to int result
        int result = foo(i);
        System.out.println(result);
    }

    public static Integer foo(Integer i) {
        System.out.println("Object = " + i);
        // No Auto-boxing: valueOf() returns Integer. If the line said return Integer.intValueOf(123)
        // then it would be a second example of auto-boxing, since the method return value is Integer
        return Integer.valueOf(123);
    }
}
