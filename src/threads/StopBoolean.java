package threads;

/**
 * Created by Alessandro on 26/03/2014.
 */
public class StopBoolean extends Thread {

    // MUST be volatile to ensure changes visible to other threads
    protected volatile boolean done = false;

    public void run() {
        while (!done) {
            System.out.println("StopBoolean running");
            try {
                sleep(720);
            } catch (InterruptedException e) {
                // nothing to do
            }
        }
        System.out.println("StopBoolean finished");
    }

    public void shutDown() {
        done = true;
    }

    public static void main(String[] args) throws InterruptedException {
        StopBoolean t1 = new StopBoolean();
        t1.start();
        Thread.sleep(1000 * 5);
        t1.shutDown();

    }
}
