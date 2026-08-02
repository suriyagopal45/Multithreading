package AtomicVariable;

import java.util.concurrent.atomic.AtomicInteger;

public class Example {

    AtomicInteger value = new AtomicInteger(0);

    Integer counter = 0;


    public static void main(String[] args) {

        Thread[] threadsAtomic = new Thread[5];

        Thread[] threadsInteger = new Thread[5];

        Example obj = new Example();
        for (int i = 0; i < 5; i++) {
            threadsAtomic[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    obj.incrementAtomicValue();
                }

            });


            threadsAtomic[i].setName("thread " + i);

            threadsAtomic[i].start();
        }


        for (int i = 0; i < 5; i++) {
            threadsInteger[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    obj.incrementInteger();
                }

            });


            threadsInteger[i].setName("thread " + i);

            threadsInteger[i].start();
        }

        //Join all the threads

        for (int i = 0; i < 5; i++) {
            try {
                threadsInteger[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < 5; i++) {
            try {
                threadsAtomic[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Atomic Value " + obj.value);
        System.out.println("Counter " + obj.counter);

    }


    public void incrementAtomicValue() {
        // value.getAndIncrement();
        //for only increment by one

        int prev, next;
        do {
            prev = value.get(); //read the current value
            next = prev + 2;   //update


        } while (!value.compareAndSet(prev, next)); //assign
    }

    public void incrementInteger() {
        counter++;
    }
}
