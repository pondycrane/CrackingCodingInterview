/**
 * Given an infinite number of quarters like 25 cents, 10 cents,
 * how many ways can you represent n cents?
 */

class Coins {
    public static void main(String[] args) {
        Coins cts = new Coins();
        int case1 = 12;
        System.out.println(case1 + ": " + cts.dpButtomUp(case1));
        
        int case2 = 24;
        System.out.println(case2 + ": " + cts.dpButtomUp(case2));

        int case3 = 50;
        System.out.println(case3 + ": " + cts.dpButtomUp(case3));

        int[] coins = { 1, 5, 10, 25 };
        System.out.println(cts.dpBU(case1, coins));
    }

    public int dpBU(int n, int[] coins) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        for (int coin: coins) {
            for (int i=coin; i<=n; i++) {
                memo[i] = memo[i - coin] + memo[i];
            }
        }
        return memo[n];
    }

    public int dpButtomUp(int n) {
        if (n < 0) return -1;
        else if (n < 5) return 1;

        int[] memo = new int[25];
        
        int now = 1;
        while (now < n) {
            int temp = 0;
            if (now < 5) temp = 1;
            else if (now < 10) temp = memo[0] + memo[5 - 1];
            else if (now < 25) temp = memo[0] + memo[5 - 1] + memo[10 - 1];
            else temp = memo[0] + memo[5 - 1] + memo[10 - 1] + memo[25 - 1];

            for (int i=24; i>0; i--) {
                memo[i] = memo[i-1];
            }

            memo[0] = temp;
            now ++;
        }
        
        return memo[0];
    }
}
