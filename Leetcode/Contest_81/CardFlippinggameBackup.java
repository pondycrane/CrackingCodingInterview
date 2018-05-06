import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class CardFlippingGame {
	public int flipgame(int[] fronts, int[] backs) {
		Map<Integer, Integer> frontMap = new HashMap();
		Map<Integer, Integer> backMap = new HashMap();
		generateHM(fronts, frontMap);
		generateHM(backs, backMap);
		Result answer = new Result(0);
		recursion(fronts, frontMap, backs, backMap, 0, answer);
		return answer.ind;
	}

	public void generateHM(int[] ints, Map<Integer, Integer> target) {
		for (int i = 0; i < ints.length; i++) {
			target.put(ints[i], target.getOrDefault(ints[i], 0) + 1);
		}
	}

	public boolean recursion(int[] fronts, Map<Integer, Integer> frontMap, int[] backs, Map<Integer, Integer> backMap, int ind, Result answer) {
		System.out.println(ind);
		System.out.println(Arrays.toString(fronts));
		System.out.println(frontMap);
		System.out.println(Arrays.toString(backs));
		System.out.println(backMap);
		// No Swap
		if (ind > 0 && backMap.get(backs[ind - 1]) > 0 && frontMap.getOrDefault(backs[ind - 1], -1) == 0) {
			answer.ind = ind;
			System.out.println("Got it!!" + ind);
			return true;
		}
		// Base case
		if (ind >= fronts.length) {
			return false;
		}
		// Swap
		int ftemp = fronts[ind];
		int btemp = backs[ind];
		fronts[ind] = btemp;
		backs[ind] = ftemp;
		frontMap.put(ftemp, frontMap.get(ftemp) - 1);
		backMap.put(btemp, backMap.get(btemp) - 1);
		frontMap.put(btemp, frontMap.getOrDefault(btemp, 0) + 1);
		backMap.put(ftemp, backMap.getOrDefault(ftemp, 0) + 1);
		if (recursion(fronts, frontMap, backs, backMap, ind + 1, answer)) {
			return true;
		}
		// Swap Back
		ftemp = fronts[ind];
		btemp = backs[ind];
		fronts[ind] = btemp;
		backs[ind] = ftemp;
		frontMap.put(ftemp, frontMap.get(ftemp) - 1);
		backMap.put(btemp, backMap.get(btemp) - 1);
		frontMap.put(btemp, frontMap.getOrDefault(btemp, 0) + 1);
		backMap.put(ftemp, backMap.getOrDefault(ftemp, 0) + 1);
		if (recursion(fronts, frontMap, backs, backMap, ind + 1, answer)) {
			return true;
		}
		return false;
	}

	private static class Result {
		public int ind;
		Result(int indd) {
			ind = indd;
		}
	}

	public static void main(String[] args) { 
		CardFlippingGame cfg = new CardFlippingGame();
		int[] fronts = {1,2,4,4,7};
		int[] backs = {1,3,4,1,3};
		System.out.println(cfg.flipgame(fronts, backs));
	}
}