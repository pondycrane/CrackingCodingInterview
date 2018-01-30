/**
 * Find the common ancestor of two nodes in a binary tree.
 * @author Hank Huang
 * @lastmodified 20170130
 */

public class FirstCommonAncestor {
    /**
     * This is a Node class for binary tree
     */
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node(int val) {
            this.val = val;
            this.right = null;
            this.left = null;
        }
    }

    public static void main(String[] args) {
        Node case1 = new Node(4);
        Node n1 = new Node(15);
        Node n2 = new Node(90);
        case1.left = new Node(1);
        case1.left.left = new Node(4);
        case1.left.right = new Node(8);
        Node anc = new Node(89);
        case1.right = anc;
        anc.left = n1;
        n1.left = new Node(0);
        n1.right = new Node(12);
        anc.right = new Node(7);
        anc.right.left = new Node(9);
        anc.right.right = n2;
        n2.right = new Node(3);
        n2.left = new Node(7);

        FirstCommonAncestor fca = new FirstCommonAncestor();
        Node found = fca.solution(case1, n1, n2);
        System.out.println("anc: " + anc.val);
        System.out.println("found: " + (found == null ? "null" : found.val));
    }

    /**
     * This is the solution for this problem.
     * @param root The node to be examined.
     * @param n1 One of the children to search.
     * @param n2 Second children to search.
     */
    public Node solution(Node root, Node n1, Node n2) {
        Node anc = new Node(0);
        boolean found = find(root, n1, n2, anc);
        return anc.left;
    }

    /**
     * This is a recursive call to find the common ancestor.
     * @param root The node to be examined.
     * @param n1 One of the children to search.
     * @param n2 Second children to search.
     * @param anc The final result.
     */
    private boolean find(Node root, Node n1, Node n2, Node anc) {
        // Base cases.
        if (root == null) return false;
        if (root == n1 || root == n2) return true;
        // Search children.
        boolean cleft = find(root.left, n1, n2, anc);
        boolean cright = find(root.right, n1, n2, anc);
        // If both children are true, current node is the common ancestor.
        if (cleft && cright) anc.left = root;
        if (cleft || cright) return true;
        return false;
    }
}
