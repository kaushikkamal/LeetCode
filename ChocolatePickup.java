// https://www.codingninjas.com/codestudio/problems/ninja-and-his-friends_3125885?leftPanelTab=0

package LeetCode;

import java.util.Arrays;

public class ChocolatePickup {

    // Space Optimized Tabulation
    // TC -> O(N * M * M) * 9
    // SC -> O(M * M)

    public static int maximumChocolates(int r, int c, int[][] grid) {
        int[][] prevDp = new int[c][c];

        for (int col1 = 0; col1 < c; col1++) {
            for (int col2 = 0; col2 < c; col2++) {
                if (col1 == col2) {
                    prevDp[col1][col2] = grid[r - 1][col1];
                } else {
                    prevDp[col1][col2] = grid[r - 1][col1] + grid[r - 1][col2];
                }
            }
        }

        for (int row = r - 2; row >= 0; row--) {
            int[][] cur = new int[c][c];

            for (int col1 = 0; col1 < c; col1++) {
                for (int col2 = 0; col2 < c; col2++) {
                    int maxi = 0;

                    for (int alice = -1; alice <= 1; alice++) {
                        for (int bob = -1; bob <= 1; bob++) {
                            if (col1 + alice >= 0 && col1 + alice < c && col2 + bob >= 0 && col2 + bob < c) {
                                maxi = Math.max(maxi, prevDp[col1 + alice][col2 + bob]);
                            }
                        }
                    }

                    if (col1 == col2) {
                        cur[col1][col2] = maxi + grid[row][col1];
                    } else {
                        cur[col1][col2] = maxi + grid[row][col1] + grid[row][col2];
                    }
                }
            }
            prevDp = cur;
        }

        return prevDp[0][c - 1];
    }

    // Tabulation
    // TC -> O(N * M * M) * 9
    // SC -> O(N * M * M)
    public static int maximumChocolates_(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];

        for (int col1 = 0; col1 < c; col1++) {
            for (int col2 = 0; col2 < c; col2++) {
                if (col1 == col2) {
                    dp[r - 1][col1][col2] = grid[r - 1][col1];
                } else {
                    dp[r - 1][col1][col2] = grid[r - 1][col1] + grid[r - 1][col2];
                }
            }
        }

        for (int row = r - 2; row >= 0; row--) {
            for (int col1 = 0; col1 < c; col1++) {
                for (int col2 = 0; col2 < c; col2++) {
                    int maxi = 0;

                    for (int alice = -1; alice <= 1; alice++) {
                        for (int bob = -1; bob <= 1; bob++) {
                            if (col1 + alice >= 0 && col1 + alice < c && col2 + bob >= 0 && col2 + bob < c) {
                                maxi = Math.max(maxi, dp[row + 1][col1 + alice][col2 + bob]);
                            }
                        }
                    }

                    if (col1 == col2) {
                        dp[row][col1][col2] = maxi + grid[row][col1];
                    } else {
                        dp[row][col1][col2] = maxi + grid[row][col1] + grid[row][col2];
                    }
                }
            }
        }

        return dp[0][0][c - 1];
    }

    // Memoization
    // TC -> O(N * M * M) * 9
    // SC -> O(N * M * M) + O(N)
    private static int maxCount__(int row, int col1, int col2, int[][] grid, int[][][] dp) {
        if (col1 < 0 || col2 < 0 || col1 >= grid[0].length || col2 >= grid[0].length) {
            return 0;
        }

        if (dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }

        if (row == grid.length - 1) {
            if (col1 == col2) {
                return grid[row][col1];
            }
            return grid[row][col1] + grid[row][col2];
        }

        int maxi = 0;

        for (int alice = -1; alice <= 1; alice++) {
            for (int bob = -1; bob <= 1; bob++) {
                maxi = Math.max(maxi, maxCount__(row + 1, col1 + alice, col2 + bob, grid, dp));
            }
        }

        if (col1 == col2) {
            dp[row][col1][col2] = maxi + grid[row][col1];
        } else {
            dp[row][col1][col2] = maxi + grid[row][col1] + grid[row][col2];
        }

        return dp[row][col1][col2];

    }

    public static int maximumChocolates__(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }

        return maxCount__(0, 0, c - 1, grid, dp);
    }

    // Recursion
    // TC -> O(3 ^ N + 3 ^ N)
    // SC -> O(N)
    private static int maxCount___(int row, int col1, int col2, int[][] grid) {
        if (col1 < 0 || col2 < 0 || col1 >= grid[0].length || col2 >= grid[0].length) {
            return 0;
        }
        if (row == grid.length - 1) {
            if (col1 == col2) {
                return grid[row][col1];
            }
            return grid[row][col1] + grid[row][col2];
        }

        int maxi = 0;

        for (int alice = -1; alice <= 1; alice++) {
            for (int bob = -1; bob <= 1; bob++) {
                maxi = Math.max(maxi, maxCount___(row + 1, col1 + alice, col2 + bob, grid));
            }
        }

        if (col1 == col2) {
            return maxi + grid[row][col1];
        }

        return maxi + grid[row][col1] + grid[row][col2];
    }

    public static int maximumChocolates___(int r, int c, int[][] grid) {
        return maxCount___(0, 0, c - 1, grid);
    }
}
