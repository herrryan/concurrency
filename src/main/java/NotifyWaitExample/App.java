package NotifyWaitExample;

import java.util.logging.Logger;

/**
 * Created by guof on 12/30/16.
 */
public class App {
    private static Logger logger = Logger.getLogger(Notifier.class.getName());
    public static void main (String[] args){
        Message msg = new Message("Process it");
        Thread waiter1 = new Thread(new Waiter(msg), "waiter1");
        Thread waiter2 = new Thread(new Waiter(msg), "waiter2");
        waiter1.start();
        waiter2.start();

        Thread notifier = new Thread(new Notifier(msg), "notifier");
        notifier.start();
        logger.info("all threads are started");
    }
}
