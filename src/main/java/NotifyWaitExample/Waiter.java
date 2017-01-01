package NotifyWaitExample;

import java.util.logging.Logger;

/**
 * Created by guof on 12/30/16.
 */
public class Waiter implements Runnable {
    Logger logger = Logger.getLogger(Waiter.class.getName());
    private Message msg;
    public Waiter (Message msg) {
        this.msg = msg;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try {
                logger.info(name + ": waiting to get notified at time: " + System.currentTimeMillis() );
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info(name + ": waiter thread got notified at time: " + System.currentTimeMillis());
            logger.info(name + ": processed: " + msg.getName());
        }
    }
}
