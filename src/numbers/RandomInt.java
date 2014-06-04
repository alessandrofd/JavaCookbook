package numbers;

import java.util.Random;

/**
 * Created by Alessandro.Dantas on 17/03/14.
 */
public class RandomInt {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 1000; i++)
            System.out.println(1 + r.nextInt(10));

    }
}
