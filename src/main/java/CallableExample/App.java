package CallableExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;

/**
 * Created by guof on 12/30/16.
 */
public class App {
    private static Logger logger = Logger.getLogger(App.class.getName());
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<String>> list = new ArrayList<Future<String>>();
        Callable<String> callable = new MyCallable();
        for (int i = 0; i < 100 ; i ++) {
            Future<String> future = executorService.submit(callable);
            list.add(future);
        }
        for (Future<String> future : list) {
            try {
                logger.info(new Date() + ": " + future.get());
            } catch (InterruptedException  e1) {
                e1.printStackTrace();
            } catch (ExecutionException  e2) {
                e2.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
