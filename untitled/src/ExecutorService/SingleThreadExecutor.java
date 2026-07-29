package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadExecutor {
    static void main() throws InterruptedException {

        ExecutorService service = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 20; i++) {
            service.execute(new Task(i));
        }

        service.shutdown();
        // to deactivate the executorservice


        service.awaitTermination(10, TimeUnit.SECONDS);

    }
}

class Task implements Runnable {
    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println(taskId + " running " + Thread.currentThread().getName());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}