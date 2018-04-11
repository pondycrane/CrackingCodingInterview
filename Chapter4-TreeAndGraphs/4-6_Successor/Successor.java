/**
 * Find the next node of a target node by in-order action in a binary search tree.
 * In-order traversal (left, root, right)
 */

import java.util.ArrayList;
import java.util.List;
import java.lang.IllegalArgumentException;
import java.lang.StringBuilder;

class Successor {
	private static TreeNode findNextNode(TreeNode root, TreeNode target) {
		return inOrderTraverse(root, target, null);
	}

	private static TreeNode inOrderTraverse(TreeNode root, TreeNode target, TreeNode parent) {
		if (root == null) {
			return null;
		}
		TreeNode leftResult = inOrderTraverse(root.left, target, root);
		if (leftResult != null) {
			return leftResult;
		}
		if (root.val == target.val) {
			if (root.right == null) {
				return parent;
			}
			return root.right;
		}
		TreeNode rightResult = inOrderTraverse(root.right, target, root);
		if (rightResult == root) {
			return parent;
		}
		return rightResult;
	}

	private static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		TreeNode(int value) {
			val = value;
		}

		public void insert(int value) {
			System.out.println("insert");
			if (value <= val) {
				if (left == null) {
					left = new TreeNode(value);
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					right = new TreeNode(value);
				} else {
					right.insert(value);
				}
			}
		}

		private static void buildArray(List<StringBuilder> al, TreeNode root, int level) {
			System.out.println(al.size());
			System.out.println("level " + level);
			if (root == null) {
				return;
			}
			if (level < 0) {
				throw new IllegalArgumentException("Level can't negative.");
			}
			if (level >= al.size()) {
				al.add(new StringBuilder(String.valueOf(root)));
				System.out.println("added " + al.size());
			} else {
				al.get(level).append(", " + String.valueOf(root));
				System.out.println(al.get(level));
			}
			//buildArray(al, root.left, level + 1);
			//buildArray(al, root.right, level + 1);
		}

		/**
		 * Printing code can be found in 
		 * https://leetcode.com/problems/print-binary-tree/description/
		 * @return The string representation of this instance.
		 */
		@Override
		public String toString() {
			List<StringBuilder> strings = new ArrayList<>();
			buildArray(strings, this, 0);
			StringBuilder finalString = new StringBuilder();
			for (int i = 0; i < strings.size(); i++) {
				finalString.append(strings.get(i).toString() + "\n");
			}
			return finalString.toString();
		}
	}

	private static TreeNode buildBinaryST(int ...values) {
		TreeNode result = null;
		for (int i = 0; i < values.length; i++) {
			if (i == 0) {
				result = new TreeNode(values[i]);
			} else {
				result.insert(values[i]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode BST = buildBinaryST(6, 2, 90, 53, 27);
		System.out.println(BST);
	}
}