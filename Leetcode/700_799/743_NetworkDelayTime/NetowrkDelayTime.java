import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class NetowrkDelayTime {
	public int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, Map<Integer, Integer>> routes = new HashMap<>();
		Set<Integer> touched = new HashSet<>();
		int[] history = getRawHistory(N);
		for (int i = 0; i < times.length; i++) {
			Map<Integer, Integer> targets = routes.getOrDefault(times[i][0], new HashMap<Integer, Integer>());
			if (targets.containsKey(times[i][1])) {
				targets.put(times[i][1], Math.min(targets.get(times[i][1]), times[i][2]));
			} else {
				targets.put(times[i][1], times[i][2]);
			}
			routes.put(times[i][0], targets);
		}
		history[K - 1] = 0;
		touched.add(K);
		dfs(routes, K, 0, history, touched);
		int maxTime = Integer.MIN_VALUE;
		for (int i = 0; i < history.length; i++) {
			if (history[i] == -1) {
				return -1;
			}
			maxTime = Math.max(maxTime, history[i]);
		}
		return maxTime;
	}

	private static int[] getRawHistory(int N) {
		int[] history = new int[N];
		for (int i = 0; i < history.length; i++) {
			history[i] = -1;
		}
		return history;
	}

	private static void dfs(Map<Integer, Map<Integer, Integer>> routes, int start, int curr, int[] history, Set<Integer> touched) {
		int ind = start - 1;
		if (history[ind] != -1 && curr > history[ind]) {
			return;
		}
		history[ind] = history[ind] == -1 ? curr : Math.min(history[ind], curr);
		Map<Integer, Integer> targets = routes.get(start);
		if (targets == null) {
			return;
		}
		for (Map.Entry<Integer, Integer> entry: targets.entrySet()) {
			if (!touched.contains(entry.getKey())) {
				touched.add(entry.getKey());
				dfs(routes, entry.getKey(), curr + entry.getValue(), history, touched);
				touched.remove(entry.getKey());
			}
		}
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