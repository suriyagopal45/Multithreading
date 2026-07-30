package ConcurrentCollections.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchExample {
    static void main() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);
        // if it mention 4 run three threads the program doesnt end it waits for
        //4th thread so allocate the valid number


        Runnable task = () -> {
            try {
                System.out.println("Waiting");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName());
                latch.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable work = () -> {
            try {
                System.out.println("Waiting");
                Thread.sleep(7000);
                System.out.println(Thread.currentThread().getName());
                latch.countDown();
                //it decrease the count
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        new Thread(work, "Worker 1").start();
        new Thread(task, "Worker 2").start();
        new Thread(task, "Worker 3").start();

        System.out.println("Main Thread waiting");

        latch.await();
        //it checks the count==0
        //it wait for all threads has to finished

        System.out.println("All worker completed");


    }
}

// await () for thread call and countdown for main thread wait
//it waits for all thread to start simultaneosuly



