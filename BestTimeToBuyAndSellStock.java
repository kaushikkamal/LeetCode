// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
package LeetCode;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
