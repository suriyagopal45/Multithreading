package ConcurrentCollections.ConcurrentMap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentReadWrite {
    static void main() {

        ConcurrentHashMap<Integer, Integer> map =
                new ConcurrentHashMap<>();


        Thread reader = new Thread(() -> {
            for (Integer key : map.keySet()) {
                System.out.println(key + " -> " + map.get(key));
            }

        });

        Thread writer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                map.put(i, i * 10);
            }

        });
        writer.start();

        reader.start();

        ConcurrentHashMap<Integer, String> map2 =
                new ConcurrentHashMap<>();

        map2.put(1, "A");
        map2.put(2, "B");

        for (Integer key : map.keySet()) {

            System.out.println(key);

            map2.put(3, "C");
//            Iterating While Modifying
//
//Unlike HashMap, you can safely modify a ConcurrentHashMap during iteration.


        }
    }
}
