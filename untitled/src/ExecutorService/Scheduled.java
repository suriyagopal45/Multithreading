package ExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduled {
    static void main() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);


        service.scheduleAtFixedRate(new Task(2), 2000, 3000, TimeUnit.MILLISECONDS);


        //keep on executing the task after a delay

        //to terminatee

        try {
            if (!service.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
                service.shutdownNow();

            }
        } catch (InterruptedException e) {
            service.shutdownNow();
            throw new RuntimeException(e);
        }


    }
}
