package MyBlockingQueueImpl;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by guof on 01/01/17.
 */
public class MyLinkedListBlockingQueue {
    private LinkedList<Integer> list = new LinkedList<Integer>();
    private Random rand = new Random();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public void put() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (list.size() == LIMIT) {
                    lock.wait();
                }
                list.add(rand.nextInt(100));
                lock.notify();
            }
        }
    }

    public void take() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (list.size() == 0) {
                    lock.wait();
                }
                int value = list.removeFirst();
                lock.notify();
                System.out.println("Queue size: " + list.size() + "; Taken Value: " + value);
            }
            Thread.sleep(2000);
        }
    }
}
