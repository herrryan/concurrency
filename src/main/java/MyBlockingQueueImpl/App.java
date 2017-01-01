package MyBlockingQueueImpl;

/**
 * Created by guof on 01/01/17.
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        final MyLinkedListBlockingQueue queue = new MyLinkedListBlockingQueue();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    queue.put();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
