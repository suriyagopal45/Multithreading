package Deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class Example {
    public static void main(String[] args) {

        ReentrantLock lockA = new ReentrantLock();
        ReentrantLock lockB = new ReentrantLock();

        Thread one = new Thread(() -> {

            lockA.lock();
            System.out.println("Lock A locked");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("trying to lockB");
            lockB.lock();

            lockA.unlock();

        });

        Thread two = new Thread(() -> {

            lockB.lock();
            System.out.println("Lock B locked");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("trying to lock A");
            lockA.lock();

            lockB.unlock();

        });

        one.start();
        two.start();

    }
}
