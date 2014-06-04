package functional;

import java.util.function.IntUnaryOperator;

/**
 * Created by Alessandro on 25/03/2014.
 */
public class ProcessIntsIntUnaryOperator {

    static int[] integers = { 0, 1, 2, 3, 4, 5 };

    static int doTheMath(int n, IntUnaryOperator func) { return func.applyAsInt(n); }

    public static void main(String[] args) {
        int total = 0;
        for (int i : integers)
            total += doTheMath(i, x -> x * x + 1);
        System.out.println("Total = " + total);
    }
}
