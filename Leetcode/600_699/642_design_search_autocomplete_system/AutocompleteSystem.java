import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.lang.Comparable;


class AutocompleteSystem {
    StringBuilder prefix = new StringBuilder();
    StringBuilder query = new StringBuilder();
    Node current = null;
    Trie trie;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        for (int i = 0; i < sentences.length; i++) {
            trie.add(sentences[i], times[i]);
        }
        current = trie.root;
    }
    
    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        if (c == '#') {
            trie.add(query.toString(), 1);
            prefix = new StringBuilder();
            query = new StringBuilder();
            current = trie.root;
            return result;
        }
        query.append(c);
        current = trie.progress(current, c);
        Queue<Sentence> queue = trie.collect(current);
        int count = 3;
        while (!queue.isEmpty() && count > 0) {
            result.add(queue.poll().sentence);
            count --;
        }
        return result;
    }
    
    private class Trie {
        public Node root;
        int size = 0;
        
        public void add(String sentence, int time) {
            root = add(sentence, root, 0, time);
        }
        
        private Node add(String sentence, Node root, int d, int time) {
            if (root == null) {
                root = new Node(0);
            }
            if (d == sentence.length()) {
                root.time += time;
                return root;
            }
            int c =  (int) sentence.charAt(d);
            if (c == 32) {
                c = 26;
            } else {
                c = c - 97;
            }
            root.next[c] = add(sentence, root.next[c], d + 1, time);
            return root;
        }
        
        public Node progress(Node current, char c) {
            if (current == null) {
                return null;
            }
            int ind;
            if (c == 32) {
                ind = 26;
            } else {
                ind = (int) (c - 97);
            }
            prefix.append(c);
            return current.next[ind];
        }
        
        public Queue<Sentence> collect(Node start) {
            Queue<Sentence> result = new PriorityQueue<>();
            if (start == null) {
                return result;
            }
            Node now = start;
            collect(now, result, prefix.toString());
            return result;
        }
        
        private void collect(Node root, Queue<Sentence> result, String pre) {
            if (root == null) {
                return;
            }
            if (root.time != 0) {
                result.add(new Sentence(pre, root.time));
            }
            for (int i = 0; i < root.next.length; i++) {
                if (root.next[i] != null) {
                    int c = i;
                    if (c == 26) {
                        c = 32;
                    } else {
                        c += 97;
                    }
                    collect(root.next[i], result, pre + (char) c);
                }
            }
        }
    }
    
    private class Sentence implements Comparable<Sentence> {
        public String sentence;
        public int time;
        Sentence(String s, int t) {
            this.sentence = s;
            this.time = t;
        }
        
        public int compareTo(Sentence other) {
            int comp = Integer.compare(other.time, this.time);
            if (comp != 0) {
                return comp;
            }
            return this.sentence.compareTo(other.sentence);
        }
        
        public String toString() {
            return "[" + this.sentence + ", " + this.time + "]";
        }
    }
    
    private class Node {
        public Node[] next = new Node[27];
        public int time;
        Node(int t) {
            this.time = t;
        }
    }

    public static void main(String[] args) {
        String[] sentences = {"i love you","island","iroman","i love leetcode"};
        int[] times = {5,3,2,2};
        AutocompleteSystem auto = new AutocompleteSystem(sentences, times);
        auto.input('i');
        auto.input(' ');
        auto.input('a');
        auto.input('#');
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
