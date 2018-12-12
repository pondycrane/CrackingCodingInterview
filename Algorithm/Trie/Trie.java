

class Trie<Value> {
    private Node root;

    Trie() {
        root = null;
    }

    public Value get(String key) {
        if (key == null) {
            return null;
        }
        Node x = get(key, root, 0);
        if (x == null) {
            return null;
        }
        return (Value) x.val;
    }

    private Node get(String key, Node root, int d) {
        if (root == null) {
            return null;
        }
        if (key.length() == d) {
            return root;
        }
        char c = key.charAt(d);
        return get(key, root.next[c], d + 1);
    }

    public void put(String key, Value value) {
        if (root == null) {
            root = new Node<>(value);
            return;
        }
        put(key, root, value, 0);
    }

    private void put(String key, Node root, Value value, int d) {
        if (key.length() == d) {
            root.val = value;
            return;
        }
        char c = key.charAt(d);
        put(key, root, value, d + 1);
    }

    private static class Node {
        public Object val;
        public Node[] next = new Node[256];
    }

    public static void main(String[] args) {
        Trie<String> trie = new Trie<>();
        trie.put("Hank", "ha");
        trie.put("Tom", "yo");
    }
}
