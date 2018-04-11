class FlipBits {
	private static int flipBits(int n) {
		int firstPosi = getFirstPosi(n);
		int mask = generateMask(firstPosi);
		return n ^ mask;
	}

	private static int generateMask(int firstPosi) {
		int mask = 1 << (firstPosi + 1);
		return mask - 1;
	}

	private static int getFirstPosi(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			if (((1<<i)&n) != 0) {
				result = i;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(flipBits(0));
		System.out.println(flipBits(1));
		System.out.println(flipBits(5));
		System.out.println(flipBits(50));
	}
}