package threads;

/**
 * Created by Alessandro.Dantas on 26/03/2014.
 */
public class ThreadsDemo3 {
    private Thread t;
    private int count;

    public static void main(String[] args) {
        new ThreadsDemo3("Hello from X", 10);
        new ThreadsDemo3("Hello from Y", 15);
    }

    public ThreadsDemo3(final String mesg, int n) {
        count = n;
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count-- > 0) {
                    System.out.println(mesg);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                System.out.println(mesg + "thread all done.");
            }
        });
        t.setName(mesg + " runner Thread");
        t.start();
    }
}
