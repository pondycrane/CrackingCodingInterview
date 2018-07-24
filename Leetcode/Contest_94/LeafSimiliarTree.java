import java.util.List;
import java.util.ArrayList;

class LeafSimiliarTree {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
        	return true;
        }
        if (root1 == null || root2 == null) {
        	return false;
        }
        List<Integer> array1 = new ArrayList<>();
        List<Integer> array2 = new ArrayList<>();
        getLeafs(array1, root1);
        getLeafs(array2, root2);
        return checkEqual(array1, array2);
    }

    private static boolean checkEqual(List<Integer> array1, List<Integer> array2) {
    	if (array1.size() != array2.size()) {
    		return false;
    	}
    	for (int i = 0; i < array1.size(); i++) {
    		if (array1.get(i) != array2.get(i)) {
    			return false;
    		}
    	}
    	return true;
    }

    private static void getLeafs(List<Integer> array, TreeNode root) {
    	if (root == null) {
    		return;
    	}
    	if (root.left == null && root.right == null) {
    		array.add(root.val);
    		return;
    	}
    	getLeafs(array, root.left);
    	getLeafs(array, root.right);
    }

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
 	}

	public static void main(String[] args) {
		LeafSimiliarTree lft = new LeafSimiliarTree();

	}
}