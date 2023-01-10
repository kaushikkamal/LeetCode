// https://leetcode.com/problems/climbing-stairs/description/

package LeetCode;

public class ClimbingStairs {
    private int count(int n) {
        int prev2 = 1;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {
            int cur = prev2 + prev1;
            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }

    public int climbStairs(int n) {
        return count(n);
    }

    // private int count(int n, int[] dp) {
    // for (int i = 2; i <= n; i++) {
    // dp[i] = dp[i - 1] + dp[i - 2];
    // }

    // return dp[n];
    // }

    // public int climbStairs(int n) {
    // int[] dp = new int[n + 1];
    // Arrays.fill(dp, -1);
    // dp[0] = 1;
    // dp[1] = 1;
    // return count(n, dp);
    // }

    // private int count(int n, int[] dp) {
    // if (n <= 1) {
    // return 1;
    // }

    // if (dp[n] != -1) {
    // return dp[n];
    // }

    // int left = count(n - 1, dp);
    // int right = count(n - 2, dp);

    // dp[n] = left + right;
    // return dp[n];
    // }

    // public int climbStairs(int n) {
    // int[] dp = new int[n + 1];
    // Arrays.fill(dp, -1);
    // return count(n, dp);
    // }
}
