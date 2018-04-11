class MinSwap {
	public static void main(String[] args) {
		int[] case1 = {6, 3, 5, 4};
		int[] case2 = {5, 8, 11, 4, 6};
		System.out.println(getInt(case1));
		System.out.println(getInt(case2));
	}

	private static int getInt(int[] a) {
		if (a.length <= 1) return 0;
		int first = 0;
		int second = a.length - 1;
		int count = 0;
		while (first < second) {
			first = moveFirst(a, first, second);
			second = moveSecond(a, first, second);
			if (first < second) {
				swap(a, first, second);
				first = first + 1;
				second = second - 1;
				count = count + 1;
			}
		}
		return count;
	}

	private static int moveFirst(int[] a, int first, int second) {
		while (first < second && a[first] % 2 == 0) {
			first = first + 1;
		}
		return first;
	}

	private static int moveSecond(int[] a, int first, int second) {
		while (first < second && a[second] % 2 == 1) {
			second = second - 1;
		}
		return second;
	}

	private static void swap(int[] a, int first, int second) {
		int tmp = a[first];
		a[first] = a[second];
		a[second] = tmp;
	}
}