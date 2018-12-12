import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;

class Solution {
    Map<Integer, Integer> treeMap;
    int max;
    int sum;
    int roof;
    int K;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        K = k;
        treeMap = buildTreeMap(nums);
        int maxSum[] = calcMaxSum(treeMap);
        max = maxSum[0];
        sum = maxSum[1];
        if (sum % k != 0) {
            return false;
        }
        roof = sum / k;
        return canPartitionKSubsets(0, 0);
    }

    public boolean canPartitionKSubsets(int kInd, int total) {
        System.out.println(treeMap);
        // Reach the finish line
        if (kInd >= K) {
            return true;
        }
        if (total > roof) {
            return false;
        }
        if (treeMap.isEmpty()) {
            return false;
        }
        Map<Integer, Integer> treeMapSnapshot = new TreeMap<>(treeMap);
        for (Map.Entry<Integer, Integer> entry: treeMapSnapshot.entrySet()) {
            System.out.println(entry);
            System.out.println("TREEMAP SNAP" + treeMap);
            int key = entry.getKey();
            int count = treeMap.get(key);
            if (count == 1) {
                treeMap.remove(key);
            } else {
                treeMap.put(key, count - 1);
                boolean canPartition;
                int newTotal = total + key;
                if (newTotal == roof) {
                    canPartition = canPartitionKSubsets(kInd + 1, 0);
                } else {
                    canPartition = canPartitionKSubsets(kInd, newTotal);
                }
                if (canPartition) {
                    return true;
                }
                // Putting it back, backtracing
                treeMap.put(key, count);
            }
        }
        return false;
    }

    public static int[] calcMaxSum(Map<Integer, Integer> treeMap) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry: treeMap.entrySet()) {
            max = Math.max(max, entry.getKey());
            sum += entry.getKey() * entry.getValue();
        }
        return new int[]{max, sum};
    }

    public static Map<Integer, Integer> buildTreeMap(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num: nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] case1Num = {4, 3, 2, 3, 5, 2, 1};
        int case1K = 4;
        System.out.println(solution.canPartitionKSubsets(case1Num, case1K));
    }
}
