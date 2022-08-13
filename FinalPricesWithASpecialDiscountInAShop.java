// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/

import java.util.ArrayDeque;
import java.util.Deque;

public class FinalPricesWithASpecialDiscountInAShop {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> s = new ArrayDeque<>();

        for (int i = prices.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() > prices[i]) {
                s.pop();
            }

            int temp = s.isEmpty() ? 0 : s.peek();
            s.push(prices[i]);
            prices[i] = prices[i] - temp;
        }

        return prices;
    }
}
