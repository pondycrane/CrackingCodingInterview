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
		TreeSet<DailyTemperature> tempTree = new TreeSet<>((a, b) -> {
			int comp = Integer.compare(a.getInd(), b.getInd());
			if (comp != 0) {
				return comp;
			} else {
				return Integer.compare(a.getTemperature(), b.getTemperature());
			}
		});

		int[] ans = new int[temperatures.length];
		for (int i = temperatures.length - 1; i >= 0; i--) {
			if (tempTree.isEmpty()) {
				ans[i] = 0;
			} else {
				
				DailyTemperature temperature = new DailyTemperature(i + 1, temperatures[i]);
				System.out.println(temperature);

				SortedSet<DailyTemperature> higherPart = tempTree.tailSet(temperature);
				System.out.println(higherPart);
				if (higherPart.isEmpty()) {
					ans[i] = 0;
				} else {
					ans[i] = higherPart.first().getInd() - i;
				}
			}
			tempTree.add(new DailyTemperature(i, temperatures[i]));
		}
		return ans;
	}

	private static class DailyTemperature {
		private int ind;
		private int temperature;
		DailyTemperature(int index, int temper) {
			ind = index;
			temperature = temper;
		}

		public int getInd() {
			return ind;
		}

		public int getTemperature() {
			return temperature;
		}

		public String toString() {
			return "{" + ind + "," + temperature + "}";
		}
	}

	public static void main(String[] args) {
		DailyTemperatures dt = new DailyTemperatures();
		int[] case1 = {73, 74, 75, 71, 69, 72, 76, 73};
		System.out.println(Arrays.toString(dt.dailyTemperatures(case1)));
		// [1, 1, 4, 2, 1, 1, 0, 0]
	}
}