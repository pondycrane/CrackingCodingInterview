import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


class Solution {
    Map<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if (map.containsKey(N)) {
            return map.get(N);
        }

        List<TreeNode> result = new ArrayList<>();
        if (N == 1) {
            result.add(new TreeNode(0));
        }
        int remain = N - 1;
        for (int i = 1; i < remain; i++) {
            List<TreeNode> left;
            List<TreeNode> right;
            left = allPossibleFBT(i);
            right = allPossibleFBT(remain - i);
            for (int j = 0; j < left.size(); j++) {
                for (int g = 0; g < right.size(); g++) {
                    TreeNode root = new TreeNode(0);
                    root.left = left.get(j);
                    root.right = right.get(g);
                    result.add(root);
                }
            }
        }
        map.put(N, result);
        return result;
    }

    public static void printListOfTreeNodes(List<TreeNode> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Wrapper.treeNodeToString(list.get(i)));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int case1 = 7;
        printListOfTreeNodes((solution.allPossibleFBT(case1)));
    }
}
