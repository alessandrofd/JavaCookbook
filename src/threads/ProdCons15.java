package threads;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Alessandro on 27/03/2014.
 */
public class ProdCons15 {
    protected volatile boolean done = false;

    /** Inner class representing the Producer side */
    class Producer implements Runnable {

        protected BlockingQueue<Object> queue;

        Producer(BlockingQueue<Object> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                while (true) {
                    Object justProduced = getRequestFromNetwork();
                    queue.put(justProduced);
                    System.out.println("Produced 1 Object. List size now " + queue.size());
                    if (done)
                        return;
                }
            } catch (InterruptedException ex) {
                System.out.println("Producer INTERRUPTED");
            }
        }

        Object getRequestFromNetwork() { // Simulation of reading from client
            try {
                Thread.sleep(10); // Simulate time passing during read
            } catch (InterruptedException ex) {
                System.out.println("Producer Reader INTERRUPTED");
            }
            return new Object();
        }
    }

    /** Inner class representing the Consumer side */
    protected class Consumer implements Runnable {

        protected BlockingQueue<Object> queue;

        public Consumer(BlockingQueue<Object> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                while (true) {
                    Object obj = queue.take();
                    System.out.println("List size now" + queue.size());
                    process(obj);
                    if (done)
                        return;
                }
            } catch (InterruptedException e) {
                System.out.println("Consumer INTERRUPTED");
            }
        }

        void process(Object obj) {
            // Thread.sleep(123); // Simulate time passing
            System.out.println("Consuming object " + obj);
        }
    }

    ProdCons15(int nP, int nC) {
        BlockingQueue<Object> myQueue = new LinkedBlockingDeque<>();
        for (int i = 0; i < nP; i++) {
            new Thread(new Producer(myQueue)).start();
        }
        for (int i = 0; i < nC; i++) {
            new Thread(new Consumer(myQueue)).start();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // Start Producers and Consumers
        int numProducers = 4;
        int numConsumers = 3;
        ProdCons15 pc = new ProdCons15(numProducers, numConsumers);

        // Let the simulation run for, say 10 seconds
        Thread.sleep(10 * 1000);

        // End of simulation - shut down gracefully
        pc.done = true;
    }
}
