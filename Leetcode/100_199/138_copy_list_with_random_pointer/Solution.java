import java.util.Map;
import java.util.HashMap;

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode now = head;
        RandomListNode copy = new RandomListNode(now.label);
        map.put(now, copy);
        RandomListNode copyNow = copy;
        while (now != null) {
            if (now.next != null && !map.containsKey(now.next)) {
                copyNow.next = new RandomListNode(now.next.label);
                map.put(now.next, copyNow.next);
            } else {
                copyNow.next = map.get(now.next);
            }
            if (now.random != null && !map.containsKey(now.random)) {
                copyNow.random = new RandomListNode(now.random.label);
                map.put(now.random, copyNow.random);
            } else {
                copyNow.random = map.get(now.random);
            }
            now = now.next;
            copyNow = copyNow.next;
        }
        return copy;
    }

    private static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }
}
