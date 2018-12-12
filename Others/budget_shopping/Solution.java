import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public static int budgetShopping(int n, List<Integer> bundleQuantities, List<Integer> bundleCosts) {
        CP[] cps = new CP[bundleQuantities.size()];
        for (int i = 0; i < bundleQuantities.size(); i++) {
            cps[i] = new CP((int) bundleQuantities.get(i), (int) bundleCosts.get(i));
        }
        Arrays.sort(cps, (a, b) -> {
            double diff = a.cp - b.cp;
            if (diff > 0) {
                return 1;
            } else if (diff < 0) {
                return -1;
            } else {
                return 0;
            }
        });
        System.out.println(Arrays.toString(cps));
        return -1;
    }

    private static class CP {
        public int quantity;
        public int cost;
        public double cp;
        CP(int q, int c) {
            this.quantity = q;
            this.cost = c;
            this.cp = ((double) this.cost) / this.quantity;
        }

        public String toString() {
            return "(" + quantity + ", " + cost + ")";
        }
    }

    public static void main(String[] args) {
        int budget = 50;
        List<Integer> quantities = Arrays.stream(new int[]{20, 19}).boxed().collect(Collectors.toList());
        List<Integer> costs = Arrays.stream(new int[]{24, 20}).boxed().collect(Collectors.toList());

        
        System.out.println(Solution.budgetShopping(budget, quantities, costs));
    }
}
