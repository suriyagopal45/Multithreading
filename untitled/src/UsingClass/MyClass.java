package UsingClass;


class Thread1 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(30);
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread1 " + i);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(30);
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread2 " + i);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

public class MyClass {

    static void main() throws InterruptedException {
        Thread t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.setPriority(Thread.MAX_PRIORITY);

        t2.setPriority(1);


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("end");

    }
}
