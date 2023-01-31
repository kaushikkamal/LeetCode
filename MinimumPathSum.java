// https://leetcode.com/problems/minimum-path-sum/description/

package LeetCode;

import java.util.Arrays;

public class MinimumPathSum {

    // Space Optimized Tabulation

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] prevDp = new int[n];

        for (int row = 0; row < m; row++) {
            int[] temp = new int[n];
            for (int col = 0; col < n; col++) {
                if (row == 0 && col == 0) {
                    temp[col] = grid[row][col];
                    continue;
                }
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;

                if (row > 0) {
                    up = prevDp[col];
                }
                if (col > 0) {
                    left = temp[col - 1];
                }

                temp[col] = grid[row][col] + Math.min(up, left);
            }
            prevDp = temp;
        }
        return prevDp[n - 1];
    }

    public int minPathSum_(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 && col == 0) {
                    dp[row][col] = grid[row][col];
                    continue;
                }
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;

                if (row > 0) {
                    up = dp[row - 1][col];
                }
                if (col > 0) {
                    left = dp[row][col - 1];
                }

                dp[row][col] = grid[row][col] + Math.min(up, left);
            }
        }
        return dp[m - 1][n - 1];
    }
    // Mameozation

    private int minCost___(int row, int col, int[][] grid, int[][] dp) {
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        if (row == 0 && col == 0) {
            return grid[row][col];
        }

        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

        if (row > 0)
            up = minCost___(row - 1, col, grid, dp);
        if (col > 0)
            left = minCost___(row, col - 1, grid, dp);

        dp[row][col] = grid[row][col] + Math.min(up, left);

        return dp[row][col];
    }

    public int minPathSum___(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return minCost___(m - 1, n - 1, grid, dp);
    }

    // Recursive

    private int minCost____(int row, int col, int[][] grid) {
        if (row == 0 && col == 0)
            return grid[row][col];

        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

        if (row > 0)
            up = minCost____(row - 1, col, grid);
        if (col > 0)
            left = minCost____(row, col - 1, grid);

        return grid[row][col] + Math.min(up, left);
    }

    public int minPathSum____(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return minCost____(m - 1, n - 1, grid);
    }
}
