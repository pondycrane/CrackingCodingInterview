import java.util.Arrays;


class MaximumSquare {
	public int maximalSquare(char[][] matrix) {
	    if (matrix == null || matrix.length == 0) {
	    	return 0;
	    }
	    int[][] area = generateArea(matrix);
	    for (int i = area.length - 1; i >= 0; i--) {
	    	for (int j = 0; j < area[0].length; j++) {
	    		if (area[i][j] == 0) {
	    			area[i][j] = 0;
	    		} else if (j == 0 || i == area.length - 1) {
	    			area[i][j] = 1;
	    		} else {
	    			area[i][j] = Math.min(area[i + 1][j], Math.min(area[i + 1][j - 1], area[i][j - 1])) + 1;
	    		}
	    	}
	    }

	    int max = 0;
		for (int i = 0; i < area.length; i++) {
			for (int j = 0; j < area[0].length; j++) {
				if (area[i][j] > max) {
					max = area[i][j];
				}
			}
		}

		return max * max;
	}

	private int[][] generateArea(char[][] matrix) {
		int[][] area = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '0') {
					area[i][j] = 0;
				} else {
					area[i][j] = 1;
				}
			}
		}
		return area;
	}

	private String areaToString(int[][] area) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < area.length; i++) {
			sb.append(Arrays.toString(area[i]));
			sb.append('\n');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		MaximumSquare ms = new MaximumSquare();
		char[][] case1 = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
		System.out.println(ms.maximalSquare(case1));

		char[][] case2 = {{'0', '0', '0'}, {'0', '0', '0'}, {'0', '0', '0'}, {'0', '0', '0'}};
		System.out.println(ms.maximalSquare(case2));
	}
}