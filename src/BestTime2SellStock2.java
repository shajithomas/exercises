/*
Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i;
 and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 */

import org.junit.Test;

public class BestTime2SellStock2 {
    public int maxProfit(int prices[]) {
        int maxprofit = 0;
        int i = 0;
        int fees = 2;
        int buy = Integer.MAX_VALUE;
        int sell = Integer.MIN_VALUE;
        while ( i < prices.length-1) {
            while (i < prices.length -1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            buy = prices[i];
            while ((i < prices.length -1) && ((prices[i] <= prices[i + 1]) || (prices[i] - buy - fees) <=0 )) {
                i++;
            }
            sell = prices[i];
            maxprofit += (sell - buy - fees);
        }

        return maxprofit;
    }

    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }

    public static void main(String[] args) {
        BestTime2SellStock2 test = new BestTime2SellStock2();
        int[] prices = {5, 3, 7, 6, 6, 8, 9};
        int profit = test.maxProfit(prices);
        System.out.println(profit);
    }

    @Test
    //todo: need to fix b/c I could have made more profit by not selling at 8 and holding it till 9 if there is a fee
    public void test1() {
        BestTime2SellStock2 test = new BestTime2SellStock2();
        int[] prices = {1, 3, 2, 9, 4, 9};
        int profit = test.maxProfit(prices);
        System.out.println(profit);
        System.out.println(maxProfit(prices, 2));
    }
}
