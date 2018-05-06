import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class ShortestDistanceToACharacter {
	public int[] shortestToChar(String S, char C) {
		if (S == null) {
			return null;
		}
		int[] arr = new int[S.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.MAX_VALUE;
		}
		List<Integer> hits = new ArrayList<>();
		// Scan for C
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == C) {
				arr[i] = 0;
				hits.add(i);
			}
		}
		for (int i = 0; i < hits.size(); i++) {
			recursion(arr, hits.get(i) + 1, 1, true);
			recursion(arr, hits.get(i) - 1, 1, false);
		}
		return arr;
	}

	public void recursion(int[] arr, int ind, int currVal, boolean right) {
		// Base case
		if (ind >= arr.length || ind < 0 || arr[ind] == 0) {
			return;
		}
		if (currVal < arr[ind]) {
			arr[ind] = currVal;
			if (right) {
				recursion(arr, ind + 1, currVal + 1, right);
			} else {
				recursion(arr, ind - 1, currVal + 1, right);
			}
		}
	}

	public static void main(String[] args) {
		ShortestDistanceToACharacter sdtac = new ShortestDistanceToACharacter();
		String S = "loveleetcode";
		char C = 'e';
		System.out.println(Arrays.toString(sdtac.shortestToChar(S, C)));
	}
}