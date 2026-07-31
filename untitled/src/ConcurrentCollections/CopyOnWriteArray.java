package ConcurrentCollections;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArray {
    static void main() throws InterruptedException {

        CopyOnWriteArrayList<Integer> list =
                new CopyOnWriteArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);


        Thread reader = new Thread(() -> {
            for (Integer x : list) {
                System.out.println("Reading : " + x);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        Thread writer = new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                list.add(i + 100);
                System.out.println("Added " + i + 100);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });


        reader.start();
        writer.start();

        reader.join();

        writer.join();

        System.out.println(list);

    }
}

//Reading : 1
//Added 0100
//Reading : 2
//Added 1100
//Reading : 3
//Added 2100
//Reading : 100
//Added 3100
//Added 4100
//[1, 2, 3, 100, 101, 102, 103, 104]


//doesn't read the new value only iterate the snapshot old array