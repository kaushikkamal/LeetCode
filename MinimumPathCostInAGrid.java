// https://leetcode.com/problems/minimum-path-cost-in-a-grid/description/

package LeetCode;

import java.util.Arrays;

public class MinimumPathCostInAGrid {
    // Space Optimized Tabulation
    // TC -> O(M * N * N)
    // SC -> O(N)
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int res = Integer.MAX_VALUE;
        int[] prevDp = new int[n];

        for (int col = 0; col < n; col++) {
            prevDp[col] = grid[m - 1][col];
        }

        for (int row = m - 2; row >= 0; row--) {
            int[] cur = new int[n];
            for (int col = 0; col < n; col++) {
                int mini = Integer.MAX_VALUE;

                for (int nextCol = 0; nextCol < n; nextCol++) {
                    mini = Math.min(mini, moveCost[grid[row][col]][nextCol] + prevDp[nextCol]);
                }

                cur[col] = grid[row][col] + mini;
            }
            prevDp = cur;
        }

        for (int col = 0; col < n; col++) {
            res = Math.min(res, prevDp[col]);
        }
        return res;
    }

    // Tabulation
    // TC -> O(M * N * N)
    // SC -> O(N * N)
    public int minPathCost_(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int res = Integer.MAX_VALUE;
        int[][] dp = new int[m][n];

        for (int col = 0; col < n; col++) {
            dp[m - 1][col] = grid[m - 1][col];
        }

        for (int row = m - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                int mini = Integer.MAX_VALUE;

                for (int nextCol = 0; nextCol < n; nextCol++) {
                    mini = Math.min(mini, moveCost[grid[row][col]][nextCol] + dp[row + 1][nextCol]);
                }

                dp[row][col] = grid[row][col] + mini;
            }
        }

        for (int col = 0; col < n; col++) {
            res = Math.min(res, dp[0][col]);
        }
        return res;
    }

    // Mempozation
    // TC -> O(M * N * N)
    // SC -> O(N * N) + O(N)
    private int f__(int row, int col, int m, int n, int[][] grid, int[][] moveCost, int[][] dp) {

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        if (row == m - 1) {
            dp[row][col] = grid[row][col];
            return dp[row][col];
        }

        int mini = Integer.MAX_VALUE;
        for (int nextCol = 0; nextCol < n; nextCol++) {
            mini = Math.min(mini, moveCost[grid[row][col]][nextCol] + f__(row + 1, nextCol, m, n, grid, moveCost, dp));
        }

        dp[row][col] = grid[row][col] + mini;
        return dp[row][col];
    }

    public int minPathCost__(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int mini = Integer.MAX_VALUE;
        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int col = 0; col < n; col++) {
            mini = Math.min(mini, f__(0, col, m, n, grid, moveCost, dp));
        }
        return mini;
    }

    // Recursive
    // TC -> O(N ^ N)
    // SC -> O(N)
    private int f___(int row, int col, int m, int n, int[][] grid, int[][] moveCost) {
        if (row == m - 1) {
            return grid[row][col];
        }

        int mini = Integer.MAX_VALUE;
        for (int nextCol = 0; nextCol < n; nextCol++) {
            mini = Math.min(mini, moveCost[grid[row][col]][nextCol] + f___(row + 1, nextCol, m, n, grid, moveCost));
        }

        return grid[row][col] + mini;
    }

    public int minPathCost___(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int mini = Integer.MAX_VALUE;

        for (int col = 0; col < n; col++) {
            mini = Math.min(mini, f___(0, col, m, n, grid, moveCost));
        }
        return mini;
    }
}
