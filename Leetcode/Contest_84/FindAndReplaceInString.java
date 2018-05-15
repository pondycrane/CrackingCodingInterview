import java.util.Map;
import java.util.TreeMap;

class FindAndReplaceInString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, String[]> tree = new TreeMap<>();
        for (int i = 0; i < indexes.length; i++) {
        	tree.put(indexes[i], new String[]{sources[i], targets[i]});
        }
        StringBuilder sb = new StringBuilder();
        int last = 0;
        for (Integer i: tree.keySet()) {
        	if (checkValid(S, i, tree.get(i)[0])) {
        		sb.append(S.substring(last, i));
        		sb.append(tree.get(i)[1]);
        		last = last + tree.get(i)[0].length() + (i - last);
        	}
        }
        /*
        for (int i = 0; i < indexes.length; i++) {
        	if (checkValid(S, indexes[i], sources[i])) {
	        	sb.append(S.substring(last, indexes[i]));
	        	sb.append(targets[i]);
	        	last = last + sources[i].length() + (indexes[i] - last);
        	}
        }
        */
        sb.append(S.substring(last, S.length()));
        return sb.toString();
    }

    private boolean checkValid(String S, int start, String subString) {
    	for (int i = start; i < (start + subString.length()); i++) {
    		if (i >= S.length()) {
    			return false;
    		}
    		if (S.charAt(i) != subString.charAt(i - start)) {
    			return false;
    		}
    	}
    	return true;
    }

    public static void main(String[] args) {
    	FindAndReplaceInString faris = new FindAndReplaceInString();
    	String S = "abcd";
    	int[] indexes = {0,2};
    	String[] sources = {"a", "cd"};
    	String[] targets = {"eee", "ffff"};
    	System.out.println(faris.findReplaceString(S, indexes, sources, targets));

    	S = "vmokgggqzp";
    	indexes = new int[]{3,5,1};
    	sources = new String[]{"kg","ggq","mo"};
    	targets = new String[]{"s","so","bfr"};
    	System.out.println(faris.findReplaceString(S, indexes, sources, targets));
    }
}