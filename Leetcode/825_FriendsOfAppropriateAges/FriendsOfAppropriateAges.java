import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        int requests = 0;
        if (ages.length <= 1) {
            return 0;
        }
        Integer[] agesBoxed = Arrays.stream(ages).boxed().toArray(Integer[]::new);
        Arrays.sort(agesBoxed, (a, b) -> b.compareTo(a));
        Set<RequestPair> found = new HashSet<>();
        for (int i = 0; i < agesBoxed.length - 1; i ++) {
        	double boundary = agesBoxed[i] * 0.5 + 7;
        	if (boundary > 57) {
        		continue;
        	}
            for (int j = i + 1; j < agesBoxed.length; j++) {
            	if (agesBoxed[j] > 100 || boundary > 57) {
            		continue;
            	}
            	if (agesBoxed[i] == agesBoxed[j]) {
            		requests++;
            	}
            	requests++;
            	/*
            	RequestPair thisPair = new RequestPair(agesBoxed[i], agesBoxed[j]);
                if (found.contains(thisPair)) {
                    requests = requests + 1;
                    if (agesBoxed[i].compareTo(agesBoxed[j]) == 0) {
                        requests = requests + 1;
                    }
                } else if (befriend(agesBoxed[i], agesBoxed[j])) {
                	// System.out.println(agesBoxed[i] + ", " + agesBoxed[j]);
                	found.add(new RequestPair(agesBoxed[i], agesBoxed[j]));
                    requests = requests + 1;
                    if (agesBoxed[i].compareTo(agesBoxed[j]) == 0) {
                        requests = requests + 1;
                    }
                }
                */
            }
        }
        return requests;
    }
    
    private boolean befriend(Integer A, Integer B) {
        if (B.compareTo(A) > 0) {
            return false;
        }
        if (B.intValue() <= (0.5 * A + 7)) {
            return false;
        }
        if (B.intValue() > 100 && A.intValue() < 100) {
            return false;
        }
        return true;
    }

    private static class RequestPair {
    	private int from;
    	private int to;

    	RequestPair(int f, int t) {
    		from = f;
    		to = t;
    	}

    	public int getFrom() {
    		return from;
    	}

    	public int getTo() {
    		return to;
    	}

    	@Override
    	public int hashCode() {
    		return from * to;
    	}

    	@Override
    	public boolean equals(Object other) {
    		if (other == this) {
    			return true;
    		}
    		if (!(other instanceof RequestPair)) {
    			return false;
    		}
    		RequestPair otherPair = (RequestPair) other;
    		return from == otherPair.getFrom() && to == otherPair.getTo();
    	}
    }

    public static void main(String[] args) {
    	FriendsOfAppropriateAges foaa = new FriendsOfAppropriateAges();
    	int[] case1 = {16, 17, 18};
    	System.out.println(foaa.numFriendRequests(case1));
    }
}