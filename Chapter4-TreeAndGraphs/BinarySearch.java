class BinarySearch {
    private static class Node {
        Integer val;
        Node left;
        Node right;
        Node(int val) {
            this.val = new Integer(val);
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(3);
        node.right = new Node(10);
        node.right.right = new Node(12);
        node.right.left = new Node(2);
        System.out.println(node.val + ", " + node.left.val + ", " + node.right.val);
        System.out.println(validateHelper(node));
    }

    public static boolean validate(Node node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }

        if (!checkBST(n.left, min, n.data) || !checkBst(n.right, n.data, max)) {
            return false;
        }
        return true;
    }
}
