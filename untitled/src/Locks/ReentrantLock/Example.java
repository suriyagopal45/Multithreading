package Locks.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        Thread one = new Thread(() ->
        {
            System.out.println("Thread 1");
            System.out.println("Thread 1 Locked");
            lock.lock();

            try {
                Thread.sleep(8000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
                System.out.println("Thread 1 unlocks the lock");
            }

        });

        Thread two = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 2 ");
            try {
                if (lock.tryLock(4000, TimeUnit.MILLISECONDS)) {
                    System.out.println("Thread 2 acquire Lock");
                } else {
                    System.out.println("Thread 2 stopped becuase it can't acquire Lock");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        one.start();
        two.start();


    }
}
