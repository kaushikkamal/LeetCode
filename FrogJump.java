// https://www.codingninjas.com/codestudio/problems/frog-jump_3621012?leftPanelTab=0

package LeetCode;

import java.util.Arrays;

public class FrogJump {

    // Space Optimed Tabulation

    public static int frogJump(int N, int heights[]) {
        int prev1 = 0;
        int prev2 = 0;

        for (int i = 1; i < N; i++) {
            int left = prev1 + Math.abs(heights[i] - heights[i - 1]);
            int right = i > 1 ? prev2 + Math.abs(heights[i] - heights[i - 2]) : Integer.MAX_VALUE;

            int cur = Math.min(left, right);
            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }

    // Tabulation

    public static int frogJump_(int N, int heights[]) {
        int[] dp = new int[N];
        dp[0] = 0;

        for (int i = 1; i < N; i++) {
            int left = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int right = i > 1 ? dp[i - 2] + Math.abs(heights[i] - heights[i - 2]) : Integer.MAX_VALUE;

            dp[i] = Math.min(left, right);
        }

        return dp[N - 1];
    }

    // Memoization
    private static int count(int index, int heights[], int[] dp) {
        if (index == 0)
            return 0;

        if (dp[index] != -1) {
            return dp[index];
        }

        int left = count(index - 1, heights, dp) + Math.abs(heights[index] - heights[index - 1]);
        int right = index > 1 ? count(index - 2, heights, dp) + Math.abs(heights[index] - heights[index - 2])
                : Integer.MAX_VALUE;

        dp[index] = Math.min(left, right);

        return dp[index];
    }

    public static int frogJump__(int N, int heights[]) {
        int[] dp = new int[N];
        Arrays.fill(dp, -1);

        return count(N - 1, heights, dp);
    }
}
