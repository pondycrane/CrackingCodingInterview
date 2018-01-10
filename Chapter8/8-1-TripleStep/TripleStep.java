/**
 * A child can run up a n steps staircase with
 * either 1 or 2 or 3 steps at a time
 * Calculate how many ways a child can run up
 * the staircase
 * Solve this using dynamic programming
 */

 import java.lang.Math;
 import java.util.Arrays;

class TripleStep {
  public static void main(String[] args) {
    TripleStep q = new TripleStep();
    int[] cases = new int[] {4, 5, 6, 7};

    System.out.println("\n");
    System.out.println("Buttom up approach: ");
    q.evaluateBottomUp(cases);

    System.out.println("\n");
    System.out.println("Memo approach: ");
    q.evaluateMemo(cases);
  }

  public void evaluateBottomUp(int[] cases) {
    for (int i=0; i<cases.length; i++) {
      System.out.println(cases[i] + ": " + ways(cases[i]));
    }
  }

  public void evaluateMemo(int[] cases) {
    for (int i=0; i<cases.length; i++) {
      System.out.println(cases[i] + ": " + countWays(cases[i]));
    }
  }

  /**
   * A bottom up approach - 
   * Combinations required for staircase N is
   * just N-1 + N-2 + N-3
   * Therefore, we only need three references
   * recording these three points
   */
  public int ways(int N) {
    if (N < 1) return 1;
    if (N == 2) return 2;
    if (N == 3) return 4;

    int one = 4;
    int two = 2;
    int three = 1;

    int start = 3;
    while (start < N) {
      int zero = one + two + three;
      three = two;
      two = one;
      one = zero;
      start ++;
    }

    return one;
  }

  public int countWays(int n) {
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);
    return countWays(n, memo);
  }

  /**
   * Memo approach - 
   * We use an array memo recording the
   * steps required for each staircases
   */
  public int countWays(int n, int[] memo) {
    if (n < 0) {
      return 0;
    } else if (n == 0) {
      return 1;
    } else if (memo[n] > -1) {
      return memo[n];
    } else {
      memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
      return memo[n];
    }
  }
}
