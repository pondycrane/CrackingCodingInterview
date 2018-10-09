import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class WordSubsets {
    public static List<String> wordSubsets(String[] A, String[] B) {
        Map<Character, Integer> requirement = new HashMap<>();
        for (String word: B) {
            Map<Character, Integer> count = buildCount(word);
            for (Map.Entry<Character, Integer> entry: count.entrySet()) {
                int currN = requirement.getOrDefault(entry.getKey(), 0);
                requirement.put(entry.getKey(), Math.max(entry.getValue(), currN));
            }
        }

        List<String> result = new ArrayList<>();
        for (String word: A) {
            Map<Character, Integer> count = buildCount(word);
            if (check(count, requirement)) {
                result.add(word);
            }
        }
            
        return result;
    }

    public static boolean check(Map<Character, Integer> count, Map<Character, Integer> requirement) {
        for (Map.Entry<Character, Integer> entry: requirement.entrySet()) {
            int currN = count.getOrDefault(entry.getKey(), 0);
            if (currN < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static Map<Character, Integer> buildCount(String word) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c: word.toCharArray()) {
            int n = count.getOrDefault(c, 0);
            count.put(c, n + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        String[] A = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] case1B = {"e", "o"};
        String[] case2B = {"l", "e"};
        String[] case3B = {"e", "oo"};
        String[] case4B = {"lo", "eo"};
        String[] case5B = {"ec", "oc", "ceo"};
        System.out.println(wordSubsets(A, case1B));
        System.out.println(wordSubsets(A, case2B));
        System.out.println(wordSubsets(A, case3B));
        System.out.println(wordSubsets(A, case4B));
        System.out.println(wordSubsets(A, case5B));
    }
}
