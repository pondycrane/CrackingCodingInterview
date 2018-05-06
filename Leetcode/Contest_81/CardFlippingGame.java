import java.util.Set;
import java.util.HashSet;

class CardFlippingGame {
	public int flipgame(int[] fronts, int[] backs) {
		Set<Integer> history = new HashSet<>();
		for (int i = 0; i < backs.length; i++) {
			if (fronts[i] == backs[i]) {
				history.add(backs[i]);
			}
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < backs.length; i++) {
			if (!history.contains(fronts[i])) {
				result = Math.min(result, fronts[i]);
			}
			if (!history.contains(backs[i])) {
				result = Math.min(result, backs[i]);
			}
		}
		return result == Integer.MAX_VALUE ? 0 : result;
	}

	public static void main(String[] args) { 
		CardFlippingGame cfg = new CardFlippingGame();
		int[] fronts1 = {1,2,4,4,7};
		int[] backs1 = {1,3,4,1,3};
		System.out.println(cfg.flipgame(fronts1, backs1));
		int[] fronts2 = {1, 1};
		int[] backs2 = {1, 2};
		System.out.println(cfg.flipgame(fronts2, backs2));
		int[] fronts3 = {2, 1};
		int[] backs3 = {1, 2};
		System.out.println(cfg.flipgame(fronts3, backs3));
		int[] fronts4 = {6,7,1,1,10,8,10,6,8,10,2,4,3,4,5,10,7,5,5,6};
		int[] backs4 = {11,11,1,9,4,2,2,8,9,6,11,9,11,11,9,11,6,1,2,6};
		System.out.println(cfg.flipgame(fronts4, backs4));
	}
}