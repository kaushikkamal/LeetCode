// https://practice.geeksforgeeks.org/problems/minimal-cost/1

package LeetCode;

import java.util.Arrays;

public class FrogJumpWithKDistances {

    // Tabulation
    public static int frogJump(int n, int[] heights, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int res = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int cur = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    res = Math.min(res, cur);
                }
            }
            dp[i] = res;
        }

        return dp[n - 1];
    }

    // Memoization
    private static int findMin_(int n, int[] heights, int k, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        int res = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {
            if (n - j >= 0) {
                int cur = findMin_(n - j, heights, k, dp) + Math.abs(heights[n] - heights[n - j]);
                res = Math.min(res, cur);
            }
        }
        dp[n] = res;
        return res;
    }

    public static int frogJump_(int N, int[] heights, int k) {
        int[] dp = new int[N];
        Arrays.fill(dp, -1);

        return findMin_(N - 1, heights, k, dp);
    }

    // Recursion
    private static int findMin__(int n, int[] heights, int k) {
        if (n == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {
            if (n - j >= 0) {
                int count = findMin__(n - j, heights, k) + (Math.abs(heights[n] - heights[n - j]));
                res = Math.min(res, count);
            }
        }

        return res;
    }

    public static int frogJump__(int N, int[] heights, int k) {
        return findMin__(N - 1, heights, k);
    }

    public static void main(String[] args) {
        int[] heights = { 30, 10, 60, 10, 60, 50 };
        int N = heights.length;
        int k = 2;
        // System.out.println(frogJump(N, heights, k));

        // System.out.println(frogJump_(N, heights, k));
        System.out.println(frogJump(N, heights, k));
    }
}
