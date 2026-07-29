package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FIxesThreadPool {

    static ExecutorService service = Executors.newFixedThreadPool(4);

    static void main() throws InterruptedException {

        for (int i = 0; i < 20; i++) {
            service.execute(new Task1(i));
        }

        service.shutdown();
    }


}

class Task1 implements Runnable {
    private final int taskId;

    public Task1(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println(taskId + " running " + Thread.currentThread().getName());

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}