package Semaphore;

import java.util.concurrent.Semaphore;

class Netflix {
    Semaphore semaphore = new Semaphore(4);

    public void login() {
        try {
            semaphore.acquire();
            //tryAcquire doesnt wait
            //acquire waits and get the connection
            System.out.println("Login Successful " + Thread.currentThread().getName());

            System.out.println("Watching Movie");
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void logout() {
        try {
            semaphore.release();
            System.out.println("Logout Successfully " + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

public class Example {
    public static void main(String[] args) {
        Netflix netflix = new Netflix();

        Thread one = new Thread(() -> {
            try {

                netflix.login();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            netflix.logout();
        });
        Thread two = new Thread(() -> {

            try {
                Thread.sleep(2000);
                netflix.login();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            netflix.logout();
        });
        Thread three = new Thread(() -> {

            try {
                Thread.sleep(1000);
                netflix.login();
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            netflix.logout();
        });
        Thread four = new Thread(() -> {

            try {
                Thread.sleep(4300);
                netflix.login();
                Thread.sleep(6400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            netflix.logout();
        });
        Thread five = new Thread(() -> {

            try {
                Thread.sleep(4300);
                netflix.login();
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            netflix.logout();
        });

        one.start();
        two.start();
        three.start();
        four.start();
        five.start();


    }
}
