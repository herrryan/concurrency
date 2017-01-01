package JoinExample;

import java.util.logging.Logger;

/**
 * Created by guof on 12/30/16.
 */
public class MyRunnable implements Runnable {
    Logger logger = Logger.getLogger(MyRunnable.class.getName());
    @Override
    public void run(){
        logger.info("Thread started: " + Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        logger.info("Thread ended: " + Thread.currentThread().getName());
    }
}
