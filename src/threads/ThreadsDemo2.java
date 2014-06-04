package threads;

/**
 * Created by Alessandro.Dantas on 26/03/2014.
 */
public class ThreadsDemo2 implements Runnable {
    private String mesg;
    private Thread t;
    private int count;

    public static void main(String[] args) {
        new ThreadsDemo2("Hello from X", 10);
        new ThreadsDemo2("Hello from Y", 15);
    }

    public ThreadsDemo2(String mesg, int count) {
        this.mesg = mesg;
        this.count = count;
        t = new Thread(this);
        t.setName(mesg + " runner thread");
        t.start();
    }

    // Run does the work. We override the run() method in Runnable.
    public void  run() {
        while (count-- > 0) {
            System.out.println(mesg);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.println(mesg + " thread all done.");
    }
}
