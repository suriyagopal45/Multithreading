package SyncCollections;

import java.util.*;

public class UsingCollection {
    static void main() throws InterruptedException {

        List<Integer> arr = Collections.synchronizedList(new ArrayList<>());


        Map<Integer, String> mpp = Collections.synchronizedMap(new HashMap<>());


//        List<Integer> arr = new ArrayList<>();


        Thread one = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                arr.add(i);
            }
        });


        Thread two = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                arr.add(i);
            }
        });

        one.start();
        two.start();

        one.join();
        two.join();

        System.out.println(arr.size());

    }
}
