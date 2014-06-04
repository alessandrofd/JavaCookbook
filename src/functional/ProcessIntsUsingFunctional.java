package functional;

/**
 * Created by Alessandro on 25/03/2014.
 */

@FunctionalInterface
interface MyFunctionalInterface {
    int compute(int x);
}

public class ProcessIntsUsingFunctional {

    static int[] integers = { 1, 2, 3 };

    private static int process(int i, MyFunctionalInterface o) { return o.compute(i); }

    public static void main(String[] args) {
        int total = 0;
        for (int i : integers)
            total += process(i, x -> x * x + 1);
        System.out.println("The total is: " + total);
    }
}
