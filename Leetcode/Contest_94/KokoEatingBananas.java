// 875
import java.util.Arrays;

class KokoEatingBananas {
	public int minEatingSpeed(int[] piles, int H) {
		Arrays.sort(piles);
		if (piles.length == H) {
			return piles[piles.length - 1];
		}
		int ansInd = binarySearch(piles, 0, piles.length - 1, H);
		int base;
		if (ansInd == 0) {
			base = 1;
		} else {
			base = piles[ansInd - 1] + 1;
		}
		return binaryFindMin(piles, ansInd, base, piles[ansInd], H);
	}

	private int binarySearch(int[] piles, int lower, int upper, int H) {
		if (lower == upper) {
			return lower;
		}
		int mid = lower + (upper - lower) / 2;
		int K = evaluate(piles, mid, H);
		if (K == 0) {
			return mid;
		} else if (K > 0) {
			return binarySearch(piles, mid + 1, upper, H);
		} else {
			return binarySearch(piles, lower, mid, H);
		}
	}

	private int evaluate(int[] piles, int currInd, int H) {
		if (currInd < 0) {
			return H;
		}
		int sofar = currInd + 1;
		int ind = sofar;
		int bound = piles[currInd];
		while (ind < piles.length && sofar <= H) {
			sofar += piles[ind] / bound;
			sofar += (piles[ind] % bound) == 0 ? 0 : 1;
			ind += 1;
		}
		if (ind < piles.length || sofar > H) {
			return 1;
		} else if (sofar == H || currInd == 0) {
			return 0;
		} else {
			return -1;
		}
	}

	private int findMin(int[] piles, int currInd, int O, int H) {
		int K = O - 1;
		int sofar = currInd + piles[currInd] / K + 1;
		int ind = currInd + 1;
		while (ind < piles.length && sofar <= H) {
			sofar += piles[ind] / K;
			sofar += (piles[ind] % K) == 0 ? 0 : 1;
			ind += 1;
		}
		if (ind < piles.length) {
			return K;
		} else if (K == 1 || sofar > H) {
			return O;
		} else {
			return findMin(piles, currInd, K, H);
		}
	}

	private int binaryFindMin(int[] piles, int currInd, int lower, int upper, int H) {
		if (lower == upper) {
			return lower;
		}
		int K = lower + (upper - lower) / 2;
		int sofar = currInd + piles[currInd] / K + 1;
		int ind = currInd + 1;
		while (ind < piles.length && sofar <= H) {
			sofar += piles[ind] / K;
			sofar += (piles[ind] % K) == 0 ? 0 : 1;
			ind += 1;
		}
		if (ind < piles.length || sofar > H) {
			return binaryFindMin(piles, currInd, K + 1, upper, H);
		} else {
			return binaryFindMin(piles, currInd, lower, K, H);
		}
	}

	public static void main(String[] args) {
		KokoEatingBananas keb = new KokoEatingBananas();

		int[] pile1 = {3, 6, 7, 11};
		int H1 = 8;
		System.out.println(keb.minEatingSpeed(pile1, H1)); // 4

		int[] pile2 = {30, 11, 23, 4, 20};
		int H2 = 5;
		System.out.println(keb.minEatingSpeed(pile2, H2)); // 30

		int[] pile3 = {30, 11, 23, 4, 20};
		int H3 = 6;
		System.out.println(keb.minEatingSpeed(pile3, H3)); // 14

		int[] pile4 = {
			332484035,
			524908576,
			855865114,
			632922376,
			222257295,
			690155293,
			112677673,
			679580077,
			337406589,
			290818316,
			877337160,
			901728858,
			679284947,
			688210097,
			692137887,
			718203285,
			629455728,
			941802184
		};
		int H4 = 823855818;
		System.out.println(keb.minEatingSpeed(pile4, H4));
	}
}