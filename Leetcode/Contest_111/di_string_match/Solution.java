import java.util.Arrays;

class Solution {
    public int[] diStringMatch(String S) {
        int dCount = 0;
        int[] arr = new int[S.length() + 1];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'D') {
                dCount += 1;
            }
        }

        int dInd = dCount - 1;
        int iInd = dCount + 1;
        arr[0] = dCount;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'D') {
                arr[i + 1] = dInd;
                dInd --;
            } else {
                arr[i + 1] = iInd;
                iInd ++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String case1 = "IDID";
        System.out.println(Arrays.toString(solution.diStringMatch(case1)));
        String case2 = "III";
        System.out.println(Arrays.toString(solution.diStringMatch(case2)));
        String case3 = "DDI";
        System.out.println(Arrays.toString(solution.diStringMatch(case3)));


    }
}
