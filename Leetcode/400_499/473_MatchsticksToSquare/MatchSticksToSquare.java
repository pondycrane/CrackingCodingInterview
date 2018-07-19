import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class MatchSticksToSquare {
    public boolean makesquare(int[] nums) {
    	if (nums == null) {
    		return false;
    	}
    	int sum = 0;
    	int curr;
    	for (int i = 0; i < nums.length; i++) {
    		sum = sum + nums[i];
    	}
    	if (sum % 4 != 0) {
    		return false;
    	} else {
    		curr = sum / 4;
    	}
        Map<Integer, Integer> count = generateCount(nums);
        return dfs(count, 0, 0, curr);
    }

    private static boolean dfs(Map<Integer, Integer> count, int level, int length, int curr) {
    	System.out.println(count + ", " + level + ", " + length + ", " + curr);
    	if (level > 4) {
    		return false;
    	}
    	boolean empty = true;
    	for (Integer key: count.keySet()) {
    		if (count.get(key) != 0) {
    			empty = false;
	    		length = length + key;
	    		count.put(key, count.get(key) - 1);
    			if (length == curr) {
	    			if (dfs(count, level + 1, 0, curr)) {
	    				return true;
	    			}
	    		} else if (length < curr) {
	    			if (dfs(count, level, length, curr)) {
	    				return true;
	    			}
	    		}
	    		length = length - key;
	    		count.put(key, count.get(key) + 1);
    		}
    	}
    	if (level == 4 && empty && length == 0) {
    		return true;
    	}
    	return false;
    }

    private static Map<Integer, Integer> generateCount(int[] nums) {
    	Map<Integer, Integer> count = new HashMap<>();
    	for (int i = 0; i < nums.length; i++) {
    		int temp = count.getOrDefault(nums[i], 0);
    		count.put(nums[i], temp + 1);
    	}
    	return count;
    }

    public static void main(String[] args) {
    	MatchSticksToSquare msts = new MatchSticksToSquare();

    	int[] case1 = {1, 1, 2, 2, 2};
    	// True
    	System.out.println(msts.makesquare(case1));

    	int[] case2 = {3, 3, 3, 3, 4};
    	// False
    	System.out.println(msts.makesquare(case2));

    	int[] case3 = {5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3};
    	// True
    	System.out.println(msts.makesquare(case3));

    	int[] case4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    	System.out.println(msts.makesquare(case4));
    }
}