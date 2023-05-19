package LeetCode;

import java.util.Arrays;

public class UncrossedLines {
    private int solve(int i, int j, int[] nums1, int[] nums2, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (nums1[i] == nums2[j]) {
            dp[i][j] = 1 + solve(i - 1, j - 1, nums1, nums2, dp);
            return dp[i][j];
        }
        dp[i][j] = Math.max(solve(i, j - 1, nums1, nums2, dp), solve(i - 1, j, nums1, nums2, dp));
        return dp[i][j];
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int i = nums1.length;
        int j = nums2.length;

        int[][] dp = new int[i][j];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(i - 1, j - 1, nums1, nums2, dp);
    }
}
