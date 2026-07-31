package Locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example {
    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();
        List<Integer> arr = new ArrayList<>();

        Thread one = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10000; i++) {
                    arr.add(i);
                }
            } finally {
                lock.unlock();
            }
        });

        Thread two = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10000; i++) {
                    arr.add(i);
                }
            } finally {
                lock.unlock();
            }
        });

        one.start();
        two.start();

        one.join();
        two.join();

        System.out.println(arr.size());


    }

}
