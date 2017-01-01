package JoinExample;

import java.util.logging.Logger;

/**
 * Created by guof on 12/30/16.
 */
public class MyThread extends Thread {
    Logger logger = Logger.getLogger(MyThread.class.getName());
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run(){
        logger.info("Thread started: " + this.getName());
        try {
            this.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        logger.info("Thread ended: " + this.getName());
    }
}
