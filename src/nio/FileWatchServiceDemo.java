package nio;

import java.io.File;
import java.nio.file.*;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class FileWatchServiceDemo {
    final static String tempDirPath = "tmp";
    static Thread mainRunner;
    static volatile boolean done = false;

    public static void main(String[] args) throws Throwable {
        System.out.println("Starting watcher for " + tempDirPath);
        Path p = Paths.get(tempDirPath);
        WatchService watcher = FileSystems.getDefault().newWatchService();
        Kind<?>[] watchKinds = { ENTRY_CREATE, ENTRY_MODIFY };
        p.register(watcher, watchKinds);
        mainRunner = Thread.currentThread();
        new Thread(new DemoService()).start();
        while(!done) {
            WatchKey key = watcher.take();
            for (WatchEvent<?> e : key.pollEvents()) {
                System.out.println("Saw event " + e.kind() + " on " + e.context());
                if (e.context().toString().equals("MyFileSema.for")) {
                    System.out.println("Semaphore found, shutting down watcher");
                    done = true;
                }
            }
            if (!key.reset()) {
                System.err.println("Key failed to reset");
            }
        }
    }

    static class DemoService implements Runnable {
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("Creating file");
                new File(tempDirPath + "/MyFileSema.for").createNewFile();
                Thread.sleep(1000);
                System.out.println("Stopping FileWatchServiceDemo");
                done = true;
                Thread.sleep(1500);
                mainRunner.interrupt();
            } catch (Exception ex) {
                System.out.println("Caught UNEXPECTED " + ex);
            }
        }
    }
}
