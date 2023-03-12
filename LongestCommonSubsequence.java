// https://leetcode.com/problems/longest-common-subsequence/description/

package LeetCode;

import java.util.Arrays;

public class LongestCommonSubsequence {

    // Space Optimized Tabulation
    // TC -> O(N * N)
    // SC -> O(N)
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[] prev = new int[m + 1];

        for (int j = 0; j <= m; j++) {
            prev[j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            int[] cur = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    cur[j] = 1 + prev[j - 1];
                } else {
                    cur[j] = Math.max(prev[j], cur[j - 1]);
                }
            }
            prev = cur;
        }

        return prev[m];
    }

    // Tabulation
    // TC -> O(N * N)
    // SC -> O(N * N)
    public int longestCommonSubsequence_(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
    // Mempozation // took n as n-1
    // TC -> O(N * M)
    // SC -> O(N * M) + O(N + M)

    private int lcs__(int i, String text1, int j, String text2, int[][] dp) {
        if (i == 0 || j == 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            dp[i][j] = 1 + lcs__(i - 1, text1, j - 1, text2, dp);
        } else {
            dp[i][j] = Math.max(lcs__(i - 1, text1, j, text2, dp), lcs__(i, text1, j - 1, text2, dp));
        }

        return dp[i][j];
    }

    public int longestCommonSubsequence__(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return lcs__(n, text1, m, text2, dp);
    }

    // Mempozation
    // TC -> O(N * M)
    // SC -> O(N * M) + O(N + M)

    private int lcs___(int i, String text1, int j, String text2, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + lcs___(i - 1, text1, j - 1, text2, dp);
        } else {
            dp[i][j] = Math.max(lcs___(i - 1, text1, j, text2, dp), lcs___(i, text1, j - 1, text2, dp));
        }

        return dp[i][j];
    }

    public int longestCommonSubsequence___(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return lcs___(n - 1, text1, m - 1, text2, dp);
    }

    // Recursive
    // TC -> > O(2 ^ N + 2 ^ M) (exponential)
    // SC -> O(N + M)
    private int lcs____(int i, String text1, int j, String text2) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + lcs____(i - 1, text1, j - 1, text2);
        }

        return Math.max(lcs____(i - 1, text1, j, text2), lcs____(i, text1, j - 1, text2));
    }

    public int longestCommonSubsequence____(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        return lcs____(n - 1, text1, m - 1, text2);
    }
}
