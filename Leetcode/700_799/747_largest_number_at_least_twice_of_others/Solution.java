import java.util.Arrays;


class Solution {
    public int dominantIndex(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] case1 = {3, 6, 1, 0};
        solution.dominantIndex(case1);
    }
}
