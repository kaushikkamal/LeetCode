// https://leetcode.com/problems/coin-change/description/

package LeetCode;

import java.util.Arrays;

class CoinChange {
    // Space Optimized Tabulation
    // TC -> O(N * amount)
    // SC -> O(amount)
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long[] prev = new long[amount + 1];
        long[] cur = new long[amount + 1];

        for (int eachAmount = 0; eachAmount <= amount; eachAmount++) {
            if (eachAmount % coins[0] == 0) {
                prev[eachAmount] = eachAmount / coins[0];
            } else {
                prev[eachAmount] = Integer.MAX_VALUE;
            }
        }

        for (int index = 1; index < n; index++) {
            for (int eachAmount = 0; eachAmount <= amount; eachAmount++) {
                long picked = Integer.MAX_VALUE, notPicked = 0;

                notPicked = prev[eachAmount];

                if (coins[index] <= eachAmount) {
                    picked = 1 + cur[eachAmount - coins[index]];
                }

                cur[eachAmount] = Math.min(picked, notPicked);
            }
            prev = cur;
        }

        long ans = prev[amount];
        if (ans >= Integer.MAX_VALUE)
            return -1;
        return (int) ans;
    }

    // Tabulation
    // TC -> O(N * amount)
    // SC -> O(N * amount)
    public int coinChange_(int[] coins, int amount) {
        int n = coins.length;
        long[][] dp = new long[n][amount + 1];

        for (int eachAmount = 0; eachAmount <= amount; eachAmount++) {
            if (eachAmount % coins[0] == 0) {
                dp[0][eachAmount] = eachAmount / coins[0];
            } else {
                dp[0][eachAmount] = Integer.MAX_VALUE;
            }
        }

        for (int index = 1; index < n; index++) {
            for (int eachAmount = 0; eachAmount <= amount; eachAmount++) {
                long picked = Integer.MAX_VALUE, notPicked = 0;

                notPicked = dp[index - 1][eachAmount];

                if (coins[index] <= eachAmount) {
                    picked = 1 + dp[index][eachAmount - coins[index]];
                }

                dp[index][eachAmount] = Math.min(picked, notPicked);
            }
        }

        long ans = dp[n - 1][amount];
        if (ans >= Integer.MAX_VALUE)
            return -1;
        return (int) ans;
    }

    // Mempozation
    // TC -> O(N * amount)
    // SC -> O(N * amount) + O(N)
    private long findMinCoin__(int index, int amount, int[] coins, long[][] dp) {
        if (index == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            }
            return Integer.MAX_VALUE;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        long picked = Integer.MAX_VALUE, notPicked = 0;

        notPicked = findMinCoin__(index - 1, amount, coins, dp);

        if (coins[index] <= amount) {
            picked = 1 + findMinCoin__(index, amount - coins[index], coins, dp);
        }

        dp[index][amount] = Math.min(picked, notPicked);
        return dp[index][amount];
    }

    public int coinChange__(int[] coins, int amount) {
        int n = coins.length;
        long[][] dp = new long[n][amount + 1];

        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        long res = findMinCoin__(n - 1, amount, coins, dp);
        if (res >= Integer.MAX_VALUE)
            return -1;
        return (int) res;
    }

    // Recursive
    // TC -> > O(2 ^ N) (Grateer than ...)
    // SC -> O(N)
    private long findMinCoin___(int index, int amount, int[] coins) {
        if (index == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            }
            return Integer.MAX_VALUE;
        }

        long picked = Integer.MAX_VALUE, notPicked = 0;

        notPicked = findMinCoin___(index - 1, amount, coins);

        if (coins[index] <= amount) {
            picked = 1 + findMinCoin___(index, amount - coins[index], coins);
        }

        return Math.min(picked, notPicked);
    }

    public int coinChange___(int[] coins, int amount) {
        int n = coins.length;
        long res = findMinCoin___(n - 1, amount, coins);
        if (res >= Integer.MAX_VALUE)
            return -1;
        return (int) res;
    }
}