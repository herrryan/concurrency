package JoinExample;

/**
 * Created by guof on 12/30/16.
 */
public class App {
    public static void main(String[] args){
        Thread t1 = new Thread(new MyRunnable(), "t1");
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        Thread t2 = new MyThread("t2");
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        Thread t3 = new Thread(new MyRunnable(), "t3");
        Thread t4 = new MyThread("t4");
        t3.start();
        t4.start();
        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}