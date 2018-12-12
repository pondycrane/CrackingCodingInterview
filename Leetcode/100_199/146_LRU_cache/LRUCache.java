import java.util.Map;
import java.util.HashMap;

class LRUCache {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        System.out.println(map);
        map.put(2, 2);
        System.out.println(map);
    }
}
