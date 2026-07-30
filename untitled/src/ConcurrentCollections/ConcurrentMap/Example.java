package ConcurrentCollections.ConcurrentMap;

import java.util.concurrent.ConcurrentHashMap;

public class Example {
    static void main() {
        ConcurrentHashMap<Integer, String> map =
                new ConcurrentHashMap<>();

        map.put(1, "Java");
        map.put(2, "Spring");

        System.out.println(map);


    }
}
