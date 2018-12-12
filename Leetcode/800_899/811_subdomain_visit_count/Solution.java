import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] fragments = cpdomains[i].split(" ");
            int count = Integer.parseInt(fragments[0]);
            String[] domains = fragments[1].split("\\.");
            for (int j = 0; j < domains.length; j++) {
                StringBuilder sb = new StringBuilder(domains[j]);
                for (int g = j + 1; g < domains.length; g++) {
                    sb.append(".");
                    sb.append(domains[g]);
                }
                String subdomain = sb.toString();
                map.put(subdomain, map.getOrDefault(subdomain, 0) + count);
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        String[] case1 = {"9001 discuss.leetcode.com"};
        Solution solution = new Solution();
        System.out.println(solution.subdomainVisits(case1));
    }
}
