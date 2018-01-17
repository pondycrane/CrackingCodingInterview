/*
 * A robot can only walk right or down, starts 
 * from upper left - How many ways the robot can
 * reach the bottom right?
 */

class RobotInAGrid {
  public static void main(String[] args) {
    RobotInAGrid q = new RobotInAGrid();
    System.out.println(q.walk(3, 4));
  }

  public int walk(int m, int n) {
    int[][] memo = new int[m][n];
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (j == 0 || i == 0) {
          memo[i][j] = 1;
        } else {
          memo[i][j] = memo[i-1][j] + memo[i][j-1];
        }
      }
    }
    return memo[m-1][n-1];
  }
}
