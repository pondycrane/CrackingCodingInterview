/**
 * A child tries to climb up a stair with N stairs.
 * How many combinations of ways can he does?
 * @author ecodi
 *
 */

import java.util.Arrays;
import java.util.List;

public class ChildrenStairs {
    
    public static void test(List<Integer> cases, Solution solution) {
        for (int i = 0; i < cases.size(); i++) {
            System.out.println("Test case " + (i + 1) + " : " + cases.get(i));
            System.out.println(solution.solution(cases.get(i)));
        }
    }
    
    /**
     * This is the recursive solution. 
     * It is the most time-consuming solution.
     * But easy to understand. 
     * @author ecodi
     *
     */
    private static class Recursive implements Solution {
        
        @Override
        public int solution(int N) {
            if (N <= 1) {
                return 1;
            }
            if (N == 2) {
                return 2;
            }
            if (N == 3) {
                return 4;
            }
            return solution(N - 1) + solution(N - 2) + solution(N - 3);
        }
    }
    
    public static void main(String[] args) {
        List<Integer> cases = Arrays.asList(10, 12, 15);
        
        Solution recursive = new Recursive();
        test(cases, recursive);
    }
}

/**
 * An solution interface
 * @author ecodi
 *
 */
interface Solution {
    public int solution(int N);
}
