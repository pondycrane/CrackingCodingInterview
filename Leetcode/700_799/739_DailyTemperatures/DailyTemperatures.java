import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.SortedSet;

/**
 * The length of temperatures will be in the range [1, 30000].
 * Each temperature will be an integer in the range [30, 100].
 */
class DailyTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {
		int[] minTempInds = new int[101];
		int[] answer = new int[temperatures.length];
		for (int i = temperatures.length - 1; i >= 0; i--) {
			minTempInds[temperatures[i]] = i;
			int minTempInd = Integer.MAX_VALUE;
			for (int j = temperatures[i] + 1; j <= 100; j++) {
				if (minTempInds[j] != 0) {
					minTempInd = Math.min(minTempInd, minTempInds[j]);
				}
			}

			if (minTempInd != Integer.MAX_VALUE) {
				answer[i] = minTempInd - i;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		DailyTemperatures dt = new DailyTemperatures();
		int[] case1 = {73, 74, 75, 71, 69, 72, 76, 73};
		System.out.println(Arrays.toString(dt.dailyTemperatures(case1)));
		// [1, 1, 4, 2, 1, 1, 0, 0]

		int[] case2 = {34,80,80,34,34,80,80,80,80,34};
		System.out.println(Arrays.toString(dt.dailyTemperatures(case2)));
		// [1,0,0,2,1,0,0,0,0,0]
	}
}