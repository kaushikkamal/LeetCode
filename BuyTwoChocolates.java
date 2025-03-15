// https://leetcode.com/problems/buy-two-chocolates/description/

package LeetCode;

public class BuyTwoChocolates {
    public int buyChoco(int[] prices, int money) {
        int firstIndex = 0;
        int secondIndex = -1;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[firstIndex]) {
                secondIndex = firstIndex;
                firstIndex = i;
            } else if (secondIndex == -1 || (prices[i] < prices[secondIndex] && i != firstIndex)) {
                secondIndex = i;
            }
        }

        return prices[firstIndex] + prices[secondIndex] > money ? money
                : money - (prices[firstIndex] + prices[secondIndex]);
    }

    public static void main(String[] args) {
        int[] prices = { 41, 1, 28, 2, 92, 97, 1, 87 };
        int money = 68;

        System.out.println(new BuyTwoChocolates().buyChoco(prices, money));
    }
}
