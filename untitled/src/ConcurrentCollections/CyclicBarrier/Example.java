package ConcurrentCollections.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Example {
    static void main() {
        CyclicBarrier barrier = new CyclicBarrier(3,
                () -> {
                    System.out.println("All threads reached the barrier");
                });
        //if all threads reached barrier it prints this

        Thread one = new Thread(() -> {
            try {
                System.out.println("Wait 1");
                Thread.sleep(4000);
                System.out.println("Start 1");
                barrier.await();

                Thread.sleep(8000);
                System.out.println("Task 1 Completed");
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        });


        Thread two = new Thread(() -> {
            try {
                System.out.println("Wait 2");
                Thread.sleep(6000);
                System.out.println("Start 2");
                barrier.await();

                Thread.sleep(5000);
                System.out.println("Task 2  Completed");
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        });


        Thread three = new Thread(() -> {
            try {
                System.out.println("Wait 3");
                Thread.sleep(9000);
                System.out.println("Start 3");
                barrier.await();

                Thread.sleep(3000);
                System.out.println("Task 3 Completed");
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        });


        one.start();
        two.start();
        three.start();


    }


}

//Wait 1
//Wait 3
//Wait 2
//Start 1
//Start 2
//Start 3
//All threads reached the barrier
//Task 3 Completed
//Task 2  Completed
//Task 1 Completed
