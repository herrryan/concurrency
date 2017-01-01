package NotifyWaitExample;

import java.util.logging.Logger;

/**
 * Created by guof on 12/30/16.
 */
public class Notifier implements Runnable {
    Logger logger = Logger.getLogger(Notifier.class.getName());
    private Message msg;

    public Notifier (Message msg) {
        this.msg = msg;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        logger.info(name + " started");
        try {
            Thread.sleep(4000);
            synchronized (msg) {
                msg.setName(name + " Notifier work done");
                msg.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
