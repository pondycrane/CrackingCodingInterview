/**
 * Given a paragraph and a list of banned words, return the most frequent
 * word that is not in the list of banned words.  It is guaranteed there is
 * at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of
 * punctuation.  Words in the paragraph are not case sensitive.  The answer
 * is in lowercase.
 *
 * Example:
 * Input: 
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation: 
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent
 * non-banned word in the paragraph. 
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"), 
 * and that "hit" isn't the answer even though it occurs more because it is
 * banned.
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> counting = new HashMap<>();
        String pattern = "[a-zA-Z_0-9]+";
        Pattern r = Pattern.compile(pattern);
        for (String word: paragraph.split(" ")) {
            Matcher m = r.matcher(word);
            if (m.find( )) {
                String theWord = m.group(0).toLowerCase();
                counting.put(theWord, counting.getOrDefault(theWord, 0) + 1);
            } 
        }
        // Convert to list
        List<Map.Entry<String, Integer>> list = new LinkedList<>(counting.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer>o2) {
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        for (Map.Entry<String, Integer> word: list) {
            if (!bannedSet.contains(word.getKey())) {
                return word.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MostCommonWord solution = new MostCommonWord();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(solution.mostCommonWord(paragraph, banned));
    }
}