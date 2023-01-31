// https://leetcode.com/problems/unique-paths-ii/description/

package LeetCode;

import java.util.Arrays;

public class UniquePathsII {

    // Space Optimized Tabulation

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prevDp = new int[n];

        for (int row = 0; row < m; row++) {
            int[] temp = new int[n];
            for (int col = 0; col < n; col++) {
                if (obstacleGrid[row][col] == 1) {
                    continue;
                }
                if (row == 0 && col == 0) {
                    temp[col] = 1;
                    continue;
                }
                int up = 0, left = 0;
                if (row > 0) {
                    up = prevDp[col];
                }
                if (col > 0) {
                    left = temp[col - 1];
                }
                temp[col] = up + left;
            }
            prevDp = temp;
        }

        return prevDp[n - 1];
    }

    // Tabulation

    public int uniquePathsWithObstacles_(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (obstacleGrid[row][col] == 1) {
                    continue;
                }
                if (row == 0 && col == 0) {
                    dp[row][col] = 1;
                    continue;
                }
                int up = 0, left = 0;
                if (row > 0) {
                    up = dp[row - 1][col];
                }
                if (col > 0) {
                    left = dp[row][col - 1];
                }
                dp[row][col] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }

    // Memoization

    private int count___(int row, int col, int[][] obstacleGrid, int[][] dp) {
        if (row < 0 || col < 0) {
            return 0;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        if (obstacleGrid[row][col] == 1) {
            return 0;
        }

        if (row == 0 && col == 0) {
            return 1;
        }

        int up = count___(row - 1, col, obstacleGrid, dp);
        int left = count___(row, col - 1, obstacleGrid, dp);

        dp[row][col] = up + left;
        return dp[row][col];
    }

    public int uniquePathsWithObstacles___(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return count___(m - 1, n - 1, obstacleGrid, dp);
    }

    // Recursive

    private int count____(int row, int col, int[][] obstacleGrid) {
        if (row < 0 || col < 0) {
            return 0;
        }
        if (obstacleGrid[row][col] == 1) {
            return 0;
        }
        if (row == 0 && col == 0) {
            return 1;
        }

        int up = count____(row - 1, col, obstacleGrid);
        int left = count____(row, col - 1, obstacleGrid);

        return up + left;
    }

    public int uniquePathsWithObstacles____(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        return count____(m - 1, n - 1, obstacleGrid);
    }
}
