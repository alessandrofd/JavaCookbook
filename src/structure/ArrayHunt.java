package structure;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Alessandro.Dantas on 20/03/2014.
 */
public class ArrayHunt {
    /**
     * the maximum (and actual) number of random ints to allocate
     */
    protected final static int MAX = 4000;
    /**
     * the value to look for
     */
    protected final static int NEEDLE = 1999;
    int[] haystack;
    Random r;

    public static void main(String[] args) {
        ArrayHunt h = new ArrayHunt();
        if (args.length == 0)
            h.play();
        else {
            int won = 0;
            int games = Integer.parseInt(args[0]);
            for (int i = 0; i < games; i++) {
                if (h.play())
                    ++won;
            }
            System.out.println("Computer won " + won + " out of " + games + ".");
        }
    }

    /** construct the playing ground */
    public ArrayHunt() {
        haystack = new int[MAX];
        r = new Random();
    }

    /** Play one game */
    public boolean play() {
        int i;

        // Fill the array with random data (hay?)
        for (i = 0; i < MAX; i++) {
            haystack[i] = (int) (r.nextFloat() * MAX);
        }

        // Precondition for binary search is that data be sorted!
        Arrays.sort(haystack);

        // Look for needle in haystack
        i = Arrays.binarySearch(haystack, NEEDLE);

        if (i >= 0) { // Found it, we win.
            System.out.println("Value " + NEEDLE + " occurs at haystack[" + i + "]");
            return true;
        } else { // Not found, we lose
            int insertionPoint = -(i+1);
            System.out.println("Value " + NEEDLE + " does not occur in haystack; nearest value is " +
                    haystack[-(i + 2)] + " (found at " + -(i + 2) + ")" + "[");
            return false;
        }
    }
}



