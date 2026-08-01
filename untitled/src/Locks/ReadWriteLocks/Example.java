package Locks.ReadWriteLocks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Example {
    public int counter = 0;
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws Exception {

        Example obj = new Example();

//        new Thread(obj::getValue, "Reader 1").start();
//        new Thread(obj::getValue, "Reader 2").start();
//        new Thread(obj::getValue, "Reader 3").start();
//
//        new Thread(obj::increment, "Reader 1").start();


        for (int i = 0; i < 2; i++) {
            Thread readerThread = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    obj.getValue();
                }

            });

            readerThread.setName("Reader " + i + 1);
            readerThread.start();
        }


        Thread writerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                obj.increment();
            }

        });

        writerThread.start();
    }


    public void increment() {
        lock.writeLock().lock();


        try {
            counter++;
            System.out.println(Thread.currentThread().getName() + " writes  " + counter);

        } finally {
            lock.writeLock().unlock();
        }

    }

    public void getValue() {
        lock.readLock().lock();


        try {
            System.out.println(Thread.currentThread().getName() + " reads  " + counter);

        } finally {
            lock.readLock().unlock();
        }

    }
}
