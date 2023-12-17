package LeetCode;

public class MinimumNumberOfCoinsForFruits {
    private int checkForMinCost(int[] prices, int curIndex, int freeFruit) {
        if (curIndex > prices.length) {
            return 0;
        }

        System.out.println("Before function call ");
        System.out.println("curIndex: " + curIndex);
        System.out.println("freeFruit: " + freeFruit);

        System.out.println();

        int ifBought = 0;
        int ifNotBought = Integer.MAX_VALUE;

        ifBought = prices[curIndex - 1] + checkForMinCost(prices, curIndex + 1, curIndex);

        if (freeFruit != 0) {
            ifNotBought = checkForMinCost(prices, curIndex + freeFruit, 0);
        }

        System.out.println("After function call ");
        System.out.println("curIndex: " + curIndex);
        System.out.println("freeFruit: " + freeFruit);
        System.out.println("ifBought: " + ifBought);
        System.out.println("ifNotBought: " + ifNotBought);
        System.out.println("Math.min(ifBought, ifNotBought): " + Math.min(ifBought, ifNotBought));

        System.out.println();

        return Math.min(ifBought, ifNotBought);
    }

    public int minimumCoins(int[] prices) {
        int curIndex = 1;
        int freeFruit = 0;

        return checkForMinCost(prices, curIndex, freeFruit);
    }

    public static void main(String[] args) {
        int[] prices = { 1, 10, 1, 1 };
        System.out.println(new MinimumNumberOfCoinsForFruits().minimumCoins(prices));
    }
}
