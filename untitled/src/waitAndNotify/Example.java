package waitAndNotify;

public class Example {
    private static final Object LOCK = new Object();

    static void main() throws InterruptedException {

        Thread one = new Thread(() -> {
            try {
                fun1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        Thread two = new Thread(() -> {
            try {
                fun2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        one.start();
        two.start();

        one.join();
        two.join();


    }

    private static void fun1() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("From Thread 1");
            LOCK.wait();
            // thread 1 waits until any other thread release the lock
            System.out.println("Finishes Thread 1");

        }
    }

    private static void fun2() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("From Thread 2");
            LOCK.notify();
            //thread 2 release the lock it performs thread 2 remaining things and moves to thread 1

            System.out.println("Finished Thread2 ");

        }
    }
}

//Step 2: Thread 1 calls wait()
//LOCK.wait();
//
//This does two things:
//
//Thread 1 goes into the WAITING state.
//        Thread 1 releases the lock immediately.


