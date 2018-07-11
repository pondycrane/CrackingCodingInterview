import java.util.Arrays;

class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length - i - 1; j++) {
                SwapResult result;
                int newI = i;
                int newJ = j;
                int temp = matrix[i][j];
                for (int t = 0; t < 4; t++) {
                    result = swap(matrix, newI, newJ, temp);
                    newI = result.i;
                    newJ = result.j;
                    temp = result.temp;
                }
            }
        }
    }

    public static SwapResult swap(int[][] matrix, int i, int j, int temp) {
        int newI = j;
        int newJ = matrix.length - i - 1;
        int newTemp = matrix[newI][newJ];
        matrix[newI][newJ] = temp;
        return new SwapResult(newI, newJ, newTemp);
    }

    private static class SwapResult {
        public int i;
        public int j;
        public int temp;
        SwapResult(int i, int j, int temp) {
            this.i = i;
            this.j = j;
            this.temp = temp;
        }
    }

    private static String matrixToString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append(Arrays.toString(matrix[i]) + "\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RotateImage ri = new RotateImage();
        int[][] case1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ri.rotate(case1);
        System.out.println(matrixToString(case1));

        int[][] case2 = {
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        };
        ri.rotate(case2);
        System.out.println(matrixToString(case2));
    }
}
