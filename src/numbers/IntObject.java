package numbers;

/**
 * To explicitly convert between an int and an Integer object, or vice versa, you can use
 * the wrapper class methods
 */
public class IntObject {
    public static void main(String[] args) {
        // int to Integer
        Integer i1 = Integer.valueOf(42);
        System.out.println(i1.toString()); // or just i1

        // Integer to int
        int i2 = i1.intValue();
        System.out.println(i2);
    }
}
