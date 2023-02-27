// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

package LeetCode;

import java.util.Arrays;

public class KnapsackProblem {
    // One Row Space Optimized Tabulation
    // TC -> O(N * W)
    // SC -> O(W)
    int knapSack(int W, int wt[], int val[], int n) {
        int[] prevDp = new int[W + 1];

        for (int i = wt[0]; i <= W; i++) {
            prevDp[i] = val[0];
        }

        for (int index = 1; index < n; index++) {
            for (int weight = W; weight >= 0; weight--) {
                int picked = 0, notPicked = 0;

                if (wt[index] <= weight) {
                    picked = val[index] + prevDp[weight - wt[index]];
                }

                notPicked = prevDp[weight];

                prevDp[weight] = Math.max(picked, notPicked);
            }
        }
        return prevDp[W];
    }

    // Space Optimized Tabulation
    // TC -> O(N * W)
    // SC -> O(W)
    int knapSack_(int W, int wt[], int val[], int n) {
        int[] prevDp = new int[W + 1];

        for (int i = wt[0]; i <= W; i++) {
            prevDp[i] = val[0];
        }

        for (int index = 1; index < n; index++) {
            int[] curDp = new int[W + 1];
            for (int weight = 0; weight <= W; weight++) {
                int picked = 0, notPicked = 0;

                if (wt[index] <= weight) {
                    picked = val[index] + prevDp[weight - wt[index]];
                }

                notPicked = prevDp[weight];

                curDp[weight] = Math.max(picked, notPicked);
            }
            prevDp = curDp;
        }
        return prevDp[W];
    }

    // Tabulation
    // TC -> O(N * W)
    // SC -> O(N * W)
    int knapSack__(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n][W + 1];

        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = val[0];
        }

        for (int index = 1; index < n; index++) {
            for (int weight = 0; weight <= W; weight++) {
                int picked = 0, notPicked = 0;

                if (wt[index] <= weight) {
                    picked = val[index] + dp[index - 1][weight - wt[index]];
                }

                notPicked = dp[index - 1][weight];

                dp[index][weight] = Math.max(picked, notPicked);
            }
        }
        return dp[n - 1][W];
    }

    // Mempozation
    // TC -> O(N * W)
    // SC -> O(N * W) + O(N)
    private int countMax___(int index, int W, int[] wt, int[] val, int[][] dp) {
        if (index == 0) {
            if (wt[0] <= W) {
                return val[0];
            }
            return 0;
        }

        if (dp[index][W] != -1) {
            return dp[index][W];
        }

        int picked = 0, notPicked = 0;

        if (wt[index] <= W) {
            picked = val[index] + countMax___(index - 1, W - wt[index], wt, val, dp);
        }

        notPicked = countMax___(index - 1, W, wt, val, dp);

        dp[index][W] = Math.max(picked, notPicked);
        return dp[index][W];
    }

    int knapSack___(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return countMax___(n - 1, W, wt, val, dp);
    }

    // Recursive
    // TC -> O(2 ^ N)
    // SC -> O(N)
    private int countMax____(int index, int W, int[] wt, int[] val) {
        if (index == 0) {
            if (wt[0] <= W) {
                return val[0];
            }
            return 0;
        }

        int picked = 0, notPicked = 0;

        if (wt[index] <= W) {
            picked = val[index] + countMax____(index - 1, W - wt[index], wt, val);
        }

        notPicked = countMax____(index - 1, W, wt, val);

        return Math.max(picked, notPicked);
    }

    int knapSack____(int W, int wt[], int val[], int n) {
        return countMax____(n - 1, W, wt, val);
    }
}
