package Synchronized;

public class Example {
    private static int counter = 0;

    static void main() {
        Thread one = new Thread(() -> {

            for (int i = 0; i < 10000; i++) {

                increment();
//                counter++;

            }

        });
        Thread two = new Thread(() -> {

            for (int i = 0; i < 10000; i++) {
                increment();  //synchronized method one thread at a time
//                counter++;
            }

        });

        one.start();
        two.start();

        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter);


    }

    private synchronized static void increment() {
        counter++;
    }
}


// two threads two synchronized method locks the entire class
//for that use lock object two to acquire different lock