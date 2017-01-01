package ConsumerProducerBlockingQuequeImpl;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by guof on 01/01/17.
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        // thread safe
        final BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                Random rand = new Random();
                while (true) {
                    try {
                        queue.put(rand.nextInt(100));//thread safe method not add(Integer..)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                Random rand = new Random();
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        if (rand.nextInt(10) == 0) {
                            int value = queue.take();
                            System.out.println("Queue size: " + queue.size() + "; Taken Value: " + value);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}

