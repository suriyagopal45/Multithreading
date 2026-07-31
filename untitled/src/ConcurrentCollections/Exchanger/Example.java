package ConcurrentCollections.Exchanger;

import java.util.concurrent.Exchanger;

public class Example {
    static void main() {

        Exchanger<String> exchanger = new Exchanger<>();
        Thread t1 = new Thread(() -> {
            try {
                String data = "Hello from Thread-1";

                System.out.println("Thread-1 sends: " + data);

                Thread.sleep(4000);
                data = exchanger.exchange(data);


                System.out.println("Thread-1 received: " + data);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                String data = "Hello from Thread-2";

                System.out.println("Thread-2 sends: " + data);

                Thread.sleep(7000);
                //Thread 1 waits until thread 2 exchange method
                data = exchanger.exchange(data);

                System.out.println("Thread-2 received: " + data);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start();
        t2.start();


    }
}
