package numbers;

import java.util.Random;

/**
 * Created by Alessandro.Dantas on 17/03/14.
 */
public class Random2 {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 10; i++)
            System.out.println("A double form java.util Random is " + r.nextDouble());
        for (int i = 0; i < 10; i++)
            System.out.println("An integer from java.util.Random is " + r.nextInt());
    }
}
