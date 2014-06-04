package threads;

import java.io.IOException;

/**
 * Created by Alessandro.Dantas on 27/03/2014.
 */
public class Join {
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                System.out.println("Reading");
                try {
                    System.in.read();
                } catch (IOException e) {
                    System.err.println(e);
                }
                System.out.println("Thread finished");
            }
        };
        System.out.println("Starting");
        t.start();
        System.out.println("Joining");
        try {
            t.join();
        } catch (InterruptedException e) {
            // should not happen
            System.out.println("Who dares interrupt my sleep?");
        }
        System.out.println("Main finished.");
    }
}
