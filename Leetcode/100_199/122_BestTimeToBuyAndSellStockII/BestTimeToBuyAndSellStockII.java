class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int total = 0;
        if (prices == null || prices.length < 2) {
            return total;
        }
        int low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                total += prices[i - 1] - low;
                low = prices[i];
            }
            if (i == prices.length - 1 && prices[i] > low) {
                total += prices[i] - low;
            }
            // System.out.println(low + ", " + prices[i] + ", " + total);
        }
        return total;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII bttbassII = new BestTimeToBuyAndSellStockII();
        int[] case1 = {7,1,5,3,6,4};
        System.out.println(bttbassII.maxProfit(case1));

        int[] case2 = {1,2,3,4,5};
        System.out.println(bttbassII.maxProfit(case2));
    }
}