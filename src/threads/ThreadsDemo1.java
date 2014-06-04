package threads;

/**
 * Created by Alessandro.Dantas on 26/03/2014.
 */
public class ThreadsDemo1 extends Thread {
    private String msg;
    private int count;

    /** Run does the work: print a message, "count" number of times */
    public void run() {
        while (count-- > 0) {
            System.out.println(msg);
            try {
                Thread.sleep(100); // in mSec
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.println(msg + " all done.");
    }

    /** Construct a ThreadsDemo1 object.
     * @param m Message to display
     * @param n How many times to display it
     */
    public ThreadsDemo1(final String m, int n) {
        this.msg = m;
        count = n;
        setName(msg + " runner Thread");
    }

    /** Main program, test driver for ThreadedDemo1 class. */
    public static void main(String[] args) {
        // could say: new ThreadsDemo1("Hello from X", 10).run();
        // could say: new ThreadsDemo1("Hello from Y", 15).run();
        // But then it wouldn't be multi-threaded!
        new ThreadsDemo1("Hello from X", 10).start();
        new ThreadsDemo1("Hello from Y", 15).start();
    }
}
