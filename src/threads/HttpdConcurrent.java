package threads;

import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * HttpdConcurrent - Httpd Subclass using java.lang.concurrent
 */
public class HttpdConcurrent extends Httpd {

    private final Executor myThreadPool;

    public HttpdConcurrent() throws Exception {
        super();
        myThreadPool = Executors.newFixedThreadPool(5);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("JavaWeb Server 0.1 starting...");
        HttpdConcurrent w = new HttpdConcurrent();
        if (args.length == 2 && args[0].equals("-p")) {
            w.startServer(Integer.parseInt(args[1]));
        } else {
            w.startServer(HTTP);
        }
        w.runServer();
    }

    public void runServer() throws Exception {
        while (true) {
            final Socket clientSock = sock.accept();
            myThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    new Handler().process(clientSock);
                }
            });
        }
    }
}
