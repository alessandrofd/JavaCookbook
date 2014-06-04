package numbers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Print "n" call to nextDouble() and nextGaussian() in raw form
 * using java.util.Random.next*(); results can be plotted (for example,
 * using the "R" script randomnesshistograms.r)
 */
public class Random4 {
    private static final int N = 1000;

    public static void main(String[] args) throws IOException {
        Random r = new Random();
        try (PrintWriter file1 = new PrintWriter(new FileWriter("file1.txt"))) {
            try (PrintWriter file2 = new PrintWriter(new FileWriter("file2.txt"))) {
                for (int i = 0; i < N; i++) {
                    file1.println(r.nextDouble());
                    file2.println(r.nextGaussian());
                }
            }
        }
    }
}
