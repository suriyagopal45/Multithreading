package SyncCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NormalCollections {
    static void main() throws InterruptedException {

        ArrayList<Integer> arr = new ArrayList<>();

        //second way
        List<Integer> arr2 = Collections.synchronizedList(new ArrayList<>());
        //using this collections always thread safe without the synchroninzed block

        Thread one = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (arr) {
                    //first way
                    arr.add(i);
                }
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (arr) {
                    arr.add(i);
                }

            }
        });

        one.start();
        two.start();

        one.join();
        two.join();

        System.out.println(arr.size());


    }
}
