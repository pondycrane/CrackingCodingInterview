

class Solution {
    int max;
    boolean[][] memory;
    int[][] matrix;

    public int maxPartition(int[][] matrix) {
        if (matrix== null || matrix.length == 0) {
            return 0;
        }
        this.max = 0;
        this.memory = new boolean[matrix.length][matrix[0].length];
        this.matrix = matrix;
        dfs(0, 0, matrix[0][0]);
        return max;
    }

    private int dfs(int y, int x, int last) {
        if (y >= matrix.length || y < 0 || x < 0 || x >= matrix[0].length || memory[y][x]) {
            return 0;
        }
        
        memory[y][x] = true;
        int currSum = 1;
        currSum += dfs(y - 1, x, matrix[y][x]);
        currSum += dfs(y, x + 1, matrix[y][x]);
        currSum += dfs(y + 1, x, matrix[y][x]);
        currSum += dfs(y, x - 1, matrix[y][x]);
        if (currSum > max) {
            max = currSum;
        }
        if (matrix[y][x] == last) {
            return currSum;
        }
        // System.out.println("y, x, last, currSum: " + x + ", " + y + ", " + last + ", " + currSum);
        return 0;
    }

    public static void main(String[] args) {
        int[][] img = {
            {0, 0, 1, 0},
            {1, 1, 0, 0},
            {1, 1, 0, 0}
        };
        Solution solution = new Solution();
        System.out.println(solution.maxPartition(img));
    }
}
