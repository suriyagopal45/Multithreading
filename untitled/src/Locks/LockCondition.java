package Locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        Condition condition = lock.newCondition();
        // create conditions for The advantage is that a ReentrantLock can have multiple Condition objects, while synchronized has only one waiting queue.
//One thread waits until another thread signals it.

        // we can create  multiple conditions
        // condition.await()
        //condition.signal()

        //if multiple threads waits for signal for one condition
        // condition.signalAll()

        Thread one = new Thread(() -> {
            lock.lock();
            try {

                System.out.println("Thread 1 Waits");
                condition.await();
                System.out.println("Thread 2 signals So Thread 1 continues");
                Thread.sleep(4000);
                System.out.println("Thread 1 finished their task");


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });

        Thread two = new Thread(() -> {
            lock.lock();
            try {
                Thread.sleep(4000);
                System.out.println("Thread 2 Starts");
                Thread.sleep(6000);
                condition.signal();
                System.out.println("Thread 2 signals ");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });

        one.start();
        two.start();

    }

}


//Thread 1 Waits
//Thread 2 Starts
//Thread 2 signals
//Thread 2 signals So Thread 1 continues
//Thread 1 finished their task