package CallableAndFuture;

import java.util.concurrent.*;

class Task implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        Thread.sleep(5000);
        return 45;
    }
}

public class Example {
    static void main() {

        try (ExecutorService service = Executors.newFixedThreadPool(3)) {

            Future<Integer> result = service.submit(new Task());
            //result did not have the final value
            System.out.println(result.get());
            //.get method fetch the value from thread pool
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        ;

    }
}
