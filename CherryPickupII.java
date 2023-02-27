// https://leetcode.com/problems/cherry-pickup-ii/

package LeetCode;

import java.util.Arrays;

class CherryPickupII {
    // Space Optimized Tabulation
    // TC -> O(N * M * M) * 9
    // SC -> O(M * M)
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] prevDp = new int[m][m];

        for (int col1 = 0; col1 < m; col1++) {
            for (int col2 = 0; col2 < m; col2++) {
                if (col1 == col2) {
                    prevDp[col1][col2] = grid[n - 1][col1];
                } else {
                    prevDp[col1][col2] = grid[n - 1][col1] + grid[n - 1][col2];
                }
            }
        }

        for (int row = n - 2; row >= 0; row--) {
            int[][] cur = new int[m][m];
            for (int col1 = 0; col1 < m; col1++) {
                for (int col2 = 0; col2 < m; col2++) {

                    int maxi = 0;

                    for (int robot1 = -1; robot1 <= 1; robot1++) {
                        for (int robot2 = -1; robot2 <= 1; robot2++) {
                            if (col1 + robot1 >= 0 && col1 + robot1 < m && col2 + robot2 >= 0 && col2 + robot2 < m) {
                                maxi = Math.max(maxi, prevDp[col1 + robot1][col2 + robot2]);
                            }
                        }
                    }

                    if (col1 == col2) {
                        maxi += grid[row][col1];
                    } else {
                        maxi += (grid[row][col1] + grid[row][col2]);
                    }

                    cur[col1][col2] = maxi;
                }
            }
            prevDp = cur;
        }

        return prevDp[0][m - 1];
    }

    // Tabulation
    // TC -> O(N * M * M) * 9
    // SC -> O(N * M * M)
    public static int cherryPickup_(int r, int c, int[][] grid) {
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

    // Mempozation
    // TC -> O(N * M * M) * 9
    // SC -> O(N * M * M) + O(N)
    private int countCherry__(int row, int col1, int col2, int n, int m, int[][] grid, int[][][] dp) {
        if (col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) {
            return 0;
        }

        if (dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }

        if (row == n - 1) {
            if (col1 == col2) {
                dp[row][col1][col2] = grid[row][col1];
                return dp[row][col1][col2];
            }

            dp[row][col1][col2] = grid[row][col1] + grid[row][col2];
            return dp[row][col1][col2];
        }

        int maxi = 0;

        for (int robot1 = -1; robot1 <= 1; robot1++) {
            for (int robot2 = -1; robot2 <= 1; robot2++) {
                maxi = Math.max(maxi, countCherry__(row + 1, col1 + robot1, col2 + robot2, n, m, grid, dp));
            }
        }

        if (col1 == col2) {
            maxi += grid[row][col1];
        } else {
            maxi += (grid[row][col1] + grid[row][col2]);
        }

        dp[row][col1][col2] = maxi;
        return dp[row][col1][col2];
    }

    public int cherryPickup__(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][][] dp = new int[row][col][col];

        for (int[][] r : dp) {
            for (int[] c : r) {
                Arrays.fill(c, -1);
            }
        }

        return countCherry__(0, 0, col - 1, row, col, grid, dp);
    }

    // Recursive
    // TC -> O(3 ^ N + 3 ^ N)
    // SC -> O(N)
    private static int maxCount___(int row, int col1, int col2, int n, int m, int[][] grid) {
        if (col1 < 0 || col2 < 0 || col1 >= m || col2 >= m) {
            return 0;
        }
        if (row == n - 1) {
            if (col1 == col2) {
                return grid[row][col1];
            }
            return grid[row][col1] + grid[row][col2];
        }

        int maxi = 0;

        for (int alice = -1; alice <= 1; alice++) {
            for (int bob = -1; bob <= 1; bob++) {
                maxi = Math.max(maxi, maxCount___(row + 1, col1 + alice, col2 + bob, n, m, grid));
            }
        }

        if (col1 == col2) {
            return maxi + grid[row][col1];
        }

        return maxi + grid[row][col1] + grid[row][col2];
    }

    public static int cherryPickup___(int r, int c, int[][] grid) {
        return maxCount___(0, 0, c - 1, r, c, grid);
    }
}