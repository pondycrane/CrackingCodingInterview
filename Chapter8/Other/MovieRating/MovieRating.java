import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given an array of ratings of a movie. You aim to find
 * the maximum sum of the ratings. Notice that for any negative
 * ratings, they can't be adjacent to each other.
 */
class MovieRating {
	private static int movieRating(int[] ratings) {
		int sum = 0;
		List<NegativePairs> pairs = new ArrayList<>();
		int consec = 0;
		int left = -1;
		for (int i = 0; i < ratings.length; i++) {
			if (ratings[i] >= 0) {
				if (consec > 1) {
					pairs.add(new NegativePairs(left, i - 1));
					left = -1;
					consec = 0;
				} else if (consec == 1) {
					sum = sum + ratings[i - 1];
				}
				sum = sum + ratings[i];
			} else {
				if (consec == 0) {
					left = i;
				}
				consec = consec + 1;
			}

			// Take care of corner case of last index
		}

		for (int i = 0; i < pairs.size(); i++) {
			int[] data = new int[pairs.get(i).getRight() - pairs.get(i).getLeft() + 1];
			System.out.println(pairs.get(i));
			System.arraycopy(ratings, pairs.get(i).getLeft(), data, 0, data.length);
			System.out.println(Arrays.toString(data));
			int bestCombi = bestCombination(data);
			System.out.println("bestCombi: " + bestCombi);
			sum = sum + bestCombi;
		}
		return sum;
	}

	private static int bestCombination(int[] ratings) {
		return bestCombinationHelper(ratings, 0, 0, Integer.MIN_VALUE);
	}

	private static int bestCombinationHelper(int[] ratings, int k, int sum, int max) {
		// Base case, array out of bound.
		if (k >= ratings.length) {
			return Math.max(sum, max);
		}
		for (int i = k; i < ratings.length; i++) {
			sum = Math.max(sum, bestCombinationHelper(ratings, i + 2, ratings[i], Integer.MIN_VALUE));
		}
		return sum + Math.max(sum, max);
	}

	private static class NegativePairs {
		private int left;
		private int right;
		NegativePairs(int l, int r) {
			left = l;
			right = r;
		}
		public int getLeft() {
			return left;
		}
		public int getRight() {
			return right;
		}
		public String toString() {
			return "Left: " + left + ", Right: " + right;
		}
	}

	public static void main(String[] args) {
		int[] case1 = {3, 2, -1, -2, 3};
		System.out.println(Arrays.toString(case1));
		System.out.println(movieRating(case1));
	}
}