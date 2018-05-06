import java.util.List;
import java.util.ArrayList;

class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
    	List<List<Integer>> result = new ArrayList<>();
    	if (S.length() < 3) {
    		return result;
    	}
    	int consecutive = 1;
    	int start = 0;
    	int end = 0;
    	char last = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
        	if (S.charAt(i) == last) {
        		consecutive++;
        		if (consecutive >= 3 && i == S.length() - 1) {
        			end = i;
        			List<Integer> pair = new ArrayList<>();
        			pair.add(start);
        			pair.add(end);
        			result.add(pair);
        		}
        	} else {
        		if (consecutive >= 3) {
        			end = i;
        			List<Integer> pair = new ArrayList<>();
        			pair.add(start);
        			pair.add(end - 1);
        			result.add(pair);
        		}
        		consecutive = 1;
        		last = S.charAt(i);
        		start = i;
        	}
        }
        return result;
    }

    public static void main(String[] args) {
    	PositionsOfLargeGroups polg = new PositionsOfLargeGroups();
    	System.out.println(polg.largeGroupPositions("abbxxxxzzy"));
    	System.out.println(polg.largeGroupPositions("aaa"));
    	System.out.println(polg.largeGroupPositions("bbacaabaccccbab"));
    }
}