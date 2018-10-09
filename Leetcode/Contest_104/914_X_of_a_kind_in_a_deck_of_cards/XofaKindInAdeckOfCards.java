import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Arrays;

class XofaKindInAdeckOfCards {
    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck.length <= 1) {
            return false;
        }
        Map<Integer, Integer> count = buildMap(deck);
        int min = findMinOfMapValue(count);
        Set<Integer> factors = allFactors(min);
        for (int factor: factors) {
            if (factor != 1) {
                boolean mistake = false;
                for (Map.Entry entry: count.entrySet()) {
                    int residual = (int) entry.getValue() % factor;
                    if (residual != 0) {
                        mistake = true;
                    }
                }
                if (mistake == false) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int findMinOfMapValue(Map<Integer, Integer> count) {
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
            }
        }
        return min;
    }

    public static Map<Integer, Integer> buildMap(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: deck) {
            int n = count.getOrDefault(num, 0);
            count.put(num, n + 1);
        }
        return count;
    }

    public static Set<Integer> allFactors(int a) {

        int upperlimit = (int)(Math.sqrt(a));
        Set<Integer> factors = new HashSet<Integer>();
        for(int i=1;i <= upperlimit; i+= 1){
            if(a%i == 0){
                factors.add(i);
                if(i != a/i){
                    factors.add(a/i);
                }
            }
        }
        return factors;
    }

    public static void processCase(int[] case1) {
        System.out.println(Arrays.toString(case1));
        System.out.println(hasGroupsSizeX(case1));
    }

    public static void main(String[] args) {
        int[] case1 = {1, 2, 3, 4, 4, 3, 2, 1};
        int[] case2 = {1, 1, 1, 2, 2, 2, 3, 3};
        int[] case3 = {1};
        int[] case4 = {1, 1};
        int[] case5 = {1, 1, 2, 2, 2, 2};
        processCase(case1);
        processCase(case2);
        processCase(case3);
        processCase(case4);
        processCase(case5);
   }
}
