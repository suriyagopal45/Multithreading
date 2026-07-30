package CallableAndFuture;

import java.util.concurrent.*;

public class MainThreadBlocked {
    static void main() {

        try (ExecutorService service = Executors.newFixedThreadPool(2)) {

            Future<Integer> result = service.submit(new Task());

            System.out.println(result.get());

            System.out.println("Main thread blocked and wait for result ");

            System.out.println(result.get(2, TimeUnit.SECONDS));
            //it wait for the given time if it wasn't it throws an exception


        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            throw new RuntimeException(e);
        }


    }
}
