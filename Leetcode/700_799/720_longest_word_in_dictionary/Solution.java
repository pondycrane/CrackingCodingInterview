class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.put(words[i]);
        }
        return trie.longestWord();
    }

    private class Trie {
        private Node root;
        private int size = 0;
            
        public void put(String word) {
            root = put(word, root, 0);
        }
        
        private Node put(String word, Node root, int d) {
            if (root == null) {
                root = new Node();
            }
            if (d == word.length()) {
                if (root.data == 0) {
                    root.data = ++size;
                }
                return root;
            }
            char c = (char) (word.charAt(d) - 97);
            root.next[c] = put(word, root.next[c], d + 1);
            return root;
        }
        
        public String longestWord() {
            if (root == null) {
                return null;
            }
            String word = "";
            return longestWord(word, root);
        }
        
        private String longestWord(String current, Node root) {
            if (root == null || (root.data == 0 && current != "")) {
                return null;
            }
            String bestWord = current;
            for (int i = 0; i < root.next.length; i++) {
                if (root.next[i] != null) {                
                    String nextWord = longestWord((current + ((char) (i + 97))), root.next[i]);
                    if (nextWord != null) {
                        if (nextWord.length() > bestWord.length()) {
                            bestWord = nextWord;
                        } else if (nextWord.length() == bestWord.length()) {
                            if (bestWord.compareTo(nextWord) > 0) {
                                bestWord = nextWord;
                            }
                        }
                    }
                }
            }
            return bestWord;
        }
    }

    private static class Node {
        public Node[] next = new Node[26];
        public int data;
    }

    public static void main(String[] args) {
        String[] case1 = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String[] case2 = {"ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"};
        Solution solution = new Solution();
        System.out.println(solution.longestWord(case1));
        System.out.println(solution.longestWord(case2));
    }
}
