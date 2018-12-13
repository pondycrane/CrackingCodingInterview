import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.lang.Comparable;


class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.put(words[i]);
        }
        return trie.getTopWords(k);
    }
    
    private class Trie {
        Node root;
        
        public void put(String word) {
            root = put(word, root, 0);
        }
        
        public List<String> getTopWords(int k) {
            Queue<Word> top = new PriorityQueue<>();
            collect("", root, top);
            List<String> list = new ArrayList<>();
            while (k > 0) {
                list.add(top.poll().word);
                k--;
            }
            return list;
        }
        
        private void collect(String current, Node root, Queue<Word> queue) {
            if (root == null) {
                return;
            }
            
            if (root.count > 0) {
                queue.add(new Word(current, root.count));
            }
            
            for (int i = 0; i < root.next.length; i++) {
                if (root.next[i] != null) {
                    collect(current + ((char) (i + 97)), root.next[i], queue);
                }
            }
        }
        
        private Node put(String word, Node root, int d) {
            if (root == null) {
                root = new Node();
            }
            if (d == word.length()) {
                root.count ++;
                return root;
            }
            char c = (char) ((int) word.charAt(d) - 97);
            root.next[c] = put(word, root.next[c], d + 1);
            return root;
        }
    }
    
    private static class Node {
        public int count = 0;
        public Node[] next = new Node[26];
    }
    
    private static class Word implements Comparable<Word> {
        public int frequency;
        public String word;
        
        Word(String w, int f) {
            this.frequency = f;
            this.word = w;
        }

        public int compareTo(Word other) {
            int freqResult = Integer.compare(other.frequency, this.frequency);
            if (freqResult != 0) {
                return freqResult;
            } else {
                return this.word.compareTo(other.word);
            }
        }
        
        public String toString() {
            return "[" + this.frequency + ", " + this.word + "]";
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] case1 = {"i", "love", "leetcode", "i", "love", "coding"};
        int k1 = 2;
        System.out.println(solution.topKFrequent(case1, k1));
    }
}
