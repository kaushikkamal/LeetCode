package LeetCode;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] arr = { 100, 180, 260, 310, 40, 535, 695 };

        System.out.println(maxProfit(arr));
    }

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
