package DaemonThread;

public class Example1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int cnt = 0;
                while (cnt < 1000) {
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    cnt++;
                    System.out.println("Daemon Thread running");

                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("user Thread finished");
            }
        });

        t1.setDaemon(true);
        //assign t1 daemon thread

        t1.start();
        t2.start();
    }
}


// Output
//
//Daemon Thread running
//Daemon Thread running
//Daemon Thread running
//Daemon Thread running
//Daemon Thread running
//user Thread finished