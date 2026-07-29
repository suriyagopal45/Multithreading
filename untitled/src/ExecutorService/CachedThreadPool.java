package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

    static void main() {

        try (ExecutorService service = Executors.newCachedThreadPool()) {

            for (int i = 0; i < 1000; i++) {
                service.execute(new Task(i));
            }

        }


    }

}
