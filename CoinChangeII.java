// https://leetcode.com/problems/coin-change-ii/description/

package LeetCode;

import java.util.Arrays;

public class CoinChangeII {
    // Space Optimized Tabulation
    // TC -> O(N * amount)
    // SC -> O(amount)
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount + 1];

        for (int eachAmount = 0; eachAmount <= amount; eachAmount++) {
            if (eachAmount % coins[0] == 0) {
                prev[eachAmount] = 1;
            } else {
                prev[eachAmount] = 0;
            }
        }

        for (int index = 1; index < n; index++) {
            int[] cur = new int[amount + 1];
            for (int eachAmount = 0; eachAmount <= amount; eachAmount++) {
                int picked = 0, notPicked = 0;

                notPicked = prev[eachAmount];

                if (coins[index] <= eachAmount) {
                    picked = cur[eachAmount - coins[index]];
                }

                cur[eachAmount] = picked + notPicked;
            }
            prev = cur;
        }

        return prev[amount];
    }

    // Tabulation
    // TC -> O(N * amount)
    // SC -> O(N * amount)
    public int change_(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int eachAmount = 0; eachAmount <= amount; eachAmount++) {
            if (eachAmount % coins[0] == 0) {
                dp[0][eachAmount] = 1;
            } else {
                dp[0][eachAmount] = 0;
            }
        }

        for (int index = 1; index < n; index++) {
            for (int eachAmount = 0; eachAmount <= amount; eachAmount++) {
                int picked = 0, notPicked = 0;

                notPicked = dp[index - 1][eachAmount];

                if (coins[index] <= eachAmount) {
                    picked = dp[index][eachAmount - coins[index]];
                }

                dp[index][eachAmount] = picked + notPicked;
            }
        }

        return dp[n - 1][amount];
    }

    // Mempozation
    // TC -> O(N * amount)
    // SC -> O(N * amount) + O(N)
    private int countCombinations(int index, int amount, int[] coins, int[][] dp) {
        if (index == 0) {
            if (amount % coins[0] == 0) {
                return 1;
            }
            return 0;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int picked = 0, notPicked = 0;

        notPicked = countCombinations(index - 1, amount, coins, dp);

        if (coins[index] <= amount) {
            picked = countCombinations(index, amount - coins[index], coins, dp);
        }

        dp[index][amount] = picked + notPicked;
        return dp[index][amount];
    }

    public int change__(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return countCombinations(n - 1, amount, coins, dp);
    }

    // Recursive
    // TC -> > O(2 ^ N) (Grateer than ...)
    // SC -> O(N)
    private int countCombinations___(int index, int amount, int[] coins) {
        if (index == 0) {
            if (amount % coins[0] == 0) {
                return 1;
            }
            return 0;
        }

        int picked = 0, notPicked = 0;

        notPicked = countCombinations___(index - 1, amount, coins);

        if (coins[index] <= amount) {
            picked = countCombinations___(index, amount - coins[index], coins);
        }

        return picked + notPicked;
    }

    public int change___(int amount, int[] coins) {
        int n = coins.length;
        return countCombinations___(n - 1, amount, coins);
    }
}
