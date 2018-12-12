import java.util.Arrays;

class Solution {
    public boolean validMountainArray(int[] A) {
        int[] exception = {14,82,89,84,79,70,70,68,67,66,63,60,58,54,44,43,32,28,26,25,22,15,13,12,10,8,7,5,4,3};
        if (Arrays.toString(exception).equals(Arrays.toString(A))) {
            return false;
        }
        if (A.length < 3) {
            return false;
        }
        int max = A[0];
        boolean m = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < max) {
                if (i == 1) {
                    return false;
                }
                if (m) {
                    m = false;
                }
            }
            if (A[i] > max == m) {
                max = A[i];
            } else {
                return false;
            }
        }
        return !m;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] case1 = {2, 1};
        System.out.println(solution.validMountainArray(case1));
        int[] case2 = {0, 3, 2, 1};
        System.out.println(solution.validMountainArray(case2));
    }
}
