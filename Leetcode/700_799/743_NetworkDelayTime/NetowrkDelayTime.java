import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.PriorityQueue;

/**
 * Use Dijkstra's algorithm.
 * BFS + weighting.
 */
class NetowrkDelayTime {
	public int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, Map<Integer, Integer>> routes = getRawRoutes(times);

		int[] cost_so_far = getRawHistory(N);
		boolean[] seen = new boolean[N + 1];
		Queue<Integer> frontier = new PriorityQueue<>();
		frontier.add(K);
		cost_so_far[K] = 0;
		while (!frontier.isEmpty()) {
			int current = frontier.poll();
			Map<Integer, Integer> targets = routes.get(current);
			if (targets != null) {
				for (Map.Entry entry: targets.entrySet()) {
					int next = (int) entry.getKey();
					int newCost = cost_so_far[current] + (int) entry.getValue();
					// Get the best cost
					if (cost_so_far[next] == -1 || cost_so_far[next] > newCost) {
						frontier.add(next);
						cost_so_far[next] = newCost;
					}
				}
			}
		}
		// Time required = biggest cost of all
		int maxTime = 0;
		for (int i = 1; i < cost_so_far.length; i++) {
			if (cost_so_far[i] == -1) {
				return -1;
			}
			maxTime = Math.max(maxTime, cost_so_far[i]);
		}
		return maxTime;
	}

	private static Map<Integer, Map<Integer, Integer>> getRawRoutes(int[][] times) {
		Map<Integer, Map<Integer, Integer>> routes = new HashMap<>();
		for (int i = 0; i < times.length; i++) {
			Map<Integer, Integer> targets = routes.getOrDefault(times[i][0], new HashMap<Integer, Integer>());
			if (targets.containsKey(times[i][1])) {
				targets.put(times[i][1], Math.min(targets.get(times[i][1]), times[i][2]));
			} else {
				targets.put(times[i][1], times[i][2]);
			}
			routes.put(times[i][0], targets);
		}
		return routes;
	}

	private static int[] getRawHistory(int N) {
		int[] cost_so_far = new int[N + 1];
		for (int i = 0; i < cost_so_far.length; i++) {
			cost_so_far[i] = -1;
		}
		return cost_so_far;
	}

	public static void main(String[] args) {
		NetowrkDelayTime ndt = new NetowrkDelayTime();
		int[][] timesCase1 = {{2,1,1}, {2,3,1}, {3,4,1}};
		int nCase1 = 4;
		int kCase1 = 2;
		System.out.println(ndt.networkDelayTime(timesCase1, nCase1, kCase1));

		int[][] timeCase2 = {{1, 2, 1}, {2, 3, 2}, {1, 3, 2}};
		int nCase2 = 3;
		int kCase2 = 1;
		System.out.println(ndt.networkDelayTime(timeCase2, nCase2, kCase2));

		int[][] timeCase3 = {{1, 2, 3}, {2, 1, 3}};
		int nCase3 = 2;
		int kCase3 = 2;
		System.out.println(ndt.networkDelayTime(timeCase3, nCase3, kCase3));
	}
}