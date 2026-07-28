package Synchronized;

public class LockObjectSolution {

    // lock the object
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    private static int counter1 = 0;
    private static int counter2 = 0;

    static void main() throws InterruptedException {

        Thread one = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                increment1();
            }

        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                increment2();
            }
        });

        one.start();
        two.start();

        one.join();
        two.join();

        System.out.println(counter1);
        System.out.println(counter2);

    }

    private static void increment1() {
        synchronized (lock1) {
            counter1++;
        }

    }

    private static void increment2() {
        synchronized (lock1) {
            counter2++;
        }
    }


}
