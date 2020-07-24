public class BestTime2SellStock {
    public int maxProfit(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        BestTime2SellStock test = new BestTime2SellStock();
        int[] prices = {5, 3, 7, 6, 4, 8, 9};
        int profit = test.maxProfit(prices);
        System.out.println(profit);
    }
}
