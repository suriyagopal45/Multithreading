package ProducerConsumer;

import java.util.ArrayList;
import java.util.List;

class Worker {

    private static int sequence = 0;
    private int minimum;
    private int maximimum;
    private List<Integer> temp;

    private Object lock = new Object();

    public Worker(int minimum, int maximimum) {
        this.minimum = minimum;
        this.maximimum = maximimum;

        this.temp = new ArrayList<>();
    }

    public void producer() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (temp.size() == maximimum) {
                    System.out.println("Container full waiting for consume");
                    lock.wait();

                } else {
                    temp.add(sequence);
                    System.out.println(sequence + " added to Container");
                    sequence++;
                    lock.notify();
                }
                Thread.sleep(2000);
            }
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (temp.size() == minimum) {
                    System.out.println("Container empty waiting for produce");
                    lock.wait();

                } else {
                    System.out.println(temp.remove(0) + " removed from container");
                    lock.notify();
                }
                Thread.sleep(3000);
            }
        }

    }


}

public class Example {
    static void main() {

        Worker worker = new Worker(0, 5);

        Thread producer = new Thread(() ->
        {
            try {
                worker.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(() ->
        {
            try {
                worker.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();


    }
}
