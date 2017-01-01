package CallableExample;

import java.util.concurrent.Callable;

/**
 * Created by guof on 12/30/16.
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName();
    }
}
