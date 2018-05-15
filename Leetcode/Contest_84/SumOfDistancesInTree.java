import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

/**
 * 834. Sum of Distances in Tree
 * An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.
 * The ith edge connects nodes edges[i][0] and edges[i][1] together.
 * Return a list ans, where ans[i] is the sum of the distances between node i 
 * and all other nodes.
 */
class SumOfDistancesInTree {
	public int[] sumOfDistancesInTree(int N, int[][] edges) {
		GraphNode[] index = new GraphNode[N];
		for (int i = 0; i < N; i++) {
			index[i] = new GraphNode(i);
		}

		for (int i = 0; i < edges.length; i++) {
			index[edges[i][0]].addChild(index[edges[i][1]]);
			index[edges[i][1]].addChild(index[edges[i][0]]);
		}

		updateCount(index[0], new HashSet<>());
		updateRes(index[0], new HashSet<>(), N);

		int[] answer = new int[N];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = index[i].getRes();
		}
		return answer;
	}

	/**
	 * The number of subnodes of a node.
	 * @param root The node to be ckecked.
	 * @param history The children of this node.
	 */
	private static void updateCount(GraphNode root, Set<GraphNode> history) {
		history.add(root);
		for (GraphNode node : root.getChildren()) {
			if (!history.contains(node)) {
				updateCount(node, history);
				root.setCount(root.getCount() + node.getCount());
				/* The distance of every subnode to root is one less than
				 * that of the root's parent. */
				root.setRes(root.getRes() + node.getRes() + node.getCount());
			}
		}
		root.setCount(root.getCount() + 1);
	}

	/**
	 * Update the total distance to all nodes. When we shift to a new children,
	 * the distance sum of the new node = parent sum distance - number of subnodes
	 * of new node + (N - number of subnodes of new node), because everytime you shift,
	 * nodes on your different side changes in the opposite direction.
	 *
	 *     * res(b) = 5                     * res(c) = res(b) - 1 + (5 - 1) = 8
	 * a - b - c                    a - b - c
	 *       \                            \
	 *         d - e                       d - e
	 *
	 * @param root The node to check.
	 * @param history The nodes already checked.
	 * @param N The number of total nodes.
	 */
	private static void updateRes(GraphNode root, Set<GraphNode> history, int N) {
		history.add(root);
		for (GraphNode node : root.getChildren()) {
			if (!history.contains(node)) {
				node.setRes(root.getRes() - node.getCount() + N - node.getCount());
				updateRes(node, history, N);
			}
		}
	}

	/**
	 * A node class that holdes the information related to a node.
	 */
	private static class GraphNode {
		/**
		 * A unique key of this node.
		 */
		private int key;
		/**
		 * Number of subnodes of this node.
		 */
		private int count;
		/**
		 * The sum distance to all other nodes.
		 */
		private int res;
		/**
		 * All children of this node.
		 */
		private Set<GraphNode> children;

		/**
		 * Constructor takes the key of this node.
		 * @param k The key of this node.
		 */
		GraphNode(int k) {
			key = k;
			children = new HashSet<>();
			count = 0;
			res = 0;
		}

		public void addChild(GraphNode child) {
			children.add(child);
		}

		public int getKey() {
			return key;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int newCount) {
			count = newCount;
		}

		public int getRes() {
			return res;
		}

		public void setRes(int newRes) {
			res = newRes;
		}

		public Set<GraphNode> getChildren() {
			return children;
		}

		@Override
		public int hashCode() {
			return key;
		}

		@Override
		public String toString() {
			return "(" + key + ", " + children.size() + " children)";
		}
	}

	public static void main(String[] args) {
		SumOfDistancesInTree sodit = new SumOfDistancesInTree();
		int size = 6;
		int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
		int[] answer = sodit.sumOfDistancesInTree(size, edges);
		System.out.println(Arrays.toString(answer));
		// [8, 12, 6, 10, 10, 10]
		/*
		 * Explanation: 
		 * Here is a diagram of the given tree:
		 *   0
		 *  / \
		 * 1   2
		 *    /|\
		 *   3 4 5
		 * We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
		 * equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
		 */

		size = 3;
		edges = new int[][]{{2,0},{1,0}};
		answer = sodit.sumOfDistancesInTree(size, edges);
		System.out.println(Arrays.toString(answer));
		// [2, 3, 3]

		size = 3;
		edges = new int[][]{{2,1},{0,2}};
		answer = sodit.sumOfDistancesInTree(size, edges);
		System.out.println(Arrays.toString(answer));
		// [3, 3, 2]

		size = 4;
		edges = new int[][]{{2,0},{3,1},{2,1}};
		answer = sodit.sumOfDistancesInTree(size, edges);
		System.out.println(Arrays.toString(answer));
		// [6, 4, 4, 6]

		size = 4;
		edges = new int[][]{{1,2},{3,2},{3,0}};
		answer = sodit.sumOfDistancesInTree(size, edges);
		System.out.println(Arrays.toString(answer));
		// [6, 6, 4, 4]
	}
}