package numbers;

import java.util.Random;

/**
 * Created by Alessandro.Dantas on 17/03/14.
 */
public class Random3 {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 10; i++)
            System.out.println("A gaussian random double is " + r.nextGaussian());
    }
}
