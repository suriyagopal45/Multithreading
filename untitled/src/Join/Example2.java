package Join;

public class Example2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    System.out.println("Thread1   " + i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("Thread2 " + i);
                }
            }
        });

        t1.start();
        t1.join();  //main threads wait for completion of thread 1
        System.out.println("T1 end");

        t2.start();
        t2.join();

        System.out.println("End");
    }
}
