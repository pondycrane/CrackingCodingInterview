/**
 * Example:
 * [1,2,3,4,5], 2 -> 9
 * [-1,2,-3,4,-5], 3 -> 3
 * [1,2,3,4], 0 -> 0
 * [1,2,3,4], 5 -> 0
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.lang.RuntimeException;

class Solution {
    Mode mode;

    Solution(Mode mode) {
        this.mode = mode;
    }

    enum Mode {
        FIXED, MINIMUM
    }

    public int maximumSubArraySum(int[] nums, int size) {
        if (size < 1 || nums == null || nums.length == 0 || size > nums.length) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int maxSum = 0;
        for (int i = 0; i < size; i++) {
            maxSum += nums[i];
        }
        max = maxSum;
        for (int i = 1; i < nums.length - size + 1; i++) {
            maxSum = maxSum - nums[i - 1] + nums[i + size - 1];
            max = Math.max(max, maxSum);
        }
        return max;
    }

    public int maximumSubArraySumMinimum(int[] nums, int size) {
        if (size < 1 || nums == null || nums.length == 0 || size > nums.length) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int maxSum = 0; 
        for (int i = 0; i < size; i++) {
            maxSum += nums[i];
        }
        max = maxSum;
        for (int i = 1; i < nums.length - size + 1; i++) {
            maxSum = maxSum + nums[i + size - 1];
            max = Math.max(max, maxSum);
        }
        for (int i = 1; i < nums.length - size + 1; i++) {
            maxSum = maxSum - nums[i - 1] + nums[i + size - 1];
            max = Math.max(max, maxSum);
        }
        return max;
    }

    private static class TestCase {
        public int[] nums;
        public int s;
        public int ans;

        public TestCase(int[] nums, int s, int ans) {
            this.nums = nums;
            this.s = s;
            this.ans = ans;
        }
    }

    private static void runTest(Solution solution, TestCase c) {
        System.out.println("nums: " + Arrays.toString(c.nums));
        System.out.println("s: " + c.s);
        switch(solution.mode) {
            case FIXED:
                System.out.println(solution.maximumSubArraySum(c.nums, c.s));
                break;
            case MINIMUM:
                System.out.println(solution.maximumSubArraySumMinimum(c.nums, c.s));
                break;
            default:
                throw new RuntimeException("No such mode!");
        }
    }

    private static void runTests(Solution solution, List<TestCase> cs) {
        for (TestCase c: cs) {
            runTest(solution, c);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(Mode.FIXED);
        Solution solution1 = new Solution(Mode.MINIMUM);
        List<TestCase> cases = new ArrayList<>();
        cases.add(new TestCase(new int[]{1, 2, 3, 4, 5}, 2, 9));
        cases.add(new TestCase(new int[]{-1, 2, -3, 4, -5}, 3, 3));
        cases.add(new TestCase(new int[]{1, 2, 3, 4}, 0, 0));
        cases.add(new TestCase(new int[]{1, 2, 3, 4}, 5, 0));
        runTests(solution, cases);
        runTests(solution1, cases);
    }
}
