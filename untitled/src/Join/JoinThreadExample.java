package Join;

public class JoinThreadExample {
    static void main() throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<40;i++)
                {
                    System.out.println("Thread1 "+i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<20;i++)
                {
                    System.out.println("Thread2 "+i);
                }
            }
        });

        t1.start();

        t2.start();

        t1.join();
        System.out.println("Thread 1 finished ");

        t2.join();
        System.out.println("Thread2 finished");
    }
}
