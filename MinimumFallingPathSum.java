// https://leetcode.com/problems/minimum-falling-path-sum/description/

package LeetCode;

import java.util.Arrays;

public class MinimumFallingPathSum {

    // Space Optimized Tabulation
    // TC -> O(N * N)
    // SC -> O(N)

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        int[] prevDp = new int[n];

        for (int col = 0; col < n; col++) {
            prevDp[col] = matrix[0][col];
        }

        for (int row = 1; row < n; row++) {
            int[] temp = new int[n];
            for (int col = 0; col < n; col++) {
                int leftDiagonal = Integer.MAX_VALUE;
                int up = Integer.MAX_VALUE;
                int rightDiagonal = Integer.MAX_VALUE;

                if (col > 0) {
                    leftDiagonal = prevDp[col - 1];
                }
                up = prevDp[col];
                if (col < n - 1) {
                    rightDiagonal = prevDp[col + 1];
                }

                temp[col] = matrix[row][col] + Math.min(leftDiagonal, Math.min(up, rightDiagonal));
            }
            prevDp = temp;
        }

        for (int col = 0; col < n; col++) {
            res = Math.min(res, prevDp[col]);
        }

        return res;
    }

    // Tabulation
    // TC -> O(N * N)
    // SC -> O(N * N)

    public int minFallingPathSum_(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];

        for (int col = 0; col < n; col++) {
            dp[0][col] = matrix[0][col];
        }

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // if(row == 0) {
                // dp[0][col] = matrix[0][col];
                // }

                int leftDiagonal = Integer.MAX_VALUE;
                int up = Integer.MAX_VALUE;
                int rightDiagonal = Integer.MAX_VALUE;

                if (col > 0) {
                    leftDiagonal = dp[row - 1][col - 1];
                }
                up = dp[row - 1][col];
                if (col < n - 1) {
                    rightDiagonal = dp[row - 1][col + 1];
                }

                dp[row][col] = matrix[row][col] + Math.min(leftDiagonal, Math.min(up, rightDiagonal));
            }
        }

        for (int col = 0; col < n; col++) {
            res = Math.min(res, dp[n - 1][col]);
        }

        return res;
    }

    // Memoization
    // TC -> O(N * N)
    // SC -> O(N) + O(N * N)

    private int min__(int row, int col, int[][] matrix, int[][] dp) {
        if (col < 0 || col >= matrix.length) {
            return Integer.MAX_VALUE;
        }

        if (row == 0) {
            return matrix[row][col];
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int leftDiagonal = min__(row - 1, col - 1, matrix, dp);
        int up = min__(row - 1, col, matrix, dp);
        int rightDiagonal = min__(row - 1, col + 1, matrix, dp);

        dp[row][col] = matrix[row][col] + Math.min(leftDiagonal, Math.min(up, rightDiagonal));
        return dp[row][col];
    }

    public int minFallingPathSum__(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int col = 0; col < n; col++) {
            res = Math.min(res, min__(n - 1, col, matrix, dp));
        }

        return res;
    }

    // Recursion
    // TC -> O(3 ^ (N * N))
    // SC -> O(N)

    private int min___(int row, int col, int[][] matrix) {
        if (col < 0 || col >= matrix.length) {
            return Integer.MAX_VALUE;
        }

        if (row == 0) {
            return matrix[row][col];
        }

        int leftDiagonal = min___(row - 1, col - 1, matrix);
        int up = min___(row - 1, col, matrix);
        int rightDiagonal = min___(row - 1, col + 1, matrix);

        return matrix[row][col] + Math.min(leftDiagonal, Math.min(up, rightDiagonal));
    }

    public int minFallingPathSum___(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;

        for (int col = 0; col < n; col++) {
            res = Math.min(res, min___(n - 1, col, matrix));
        }

        return res;
    }
}
