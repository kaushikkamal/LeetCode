package LeetCode;

import java.util.Arrays;

public class UniquePaths {

    // Space Optimized Tabulation

    // TC -> O(m * n) // number of state // how many calls
    // (0, 0), (0, 1), (0, 2), (0, 3)
    // (1, 0), (1, 1), (1, 2), (1, 3)
    // (3, 0), (3, 1), (3, 2), (3, 3)
    // (4, 0), (4, 1), (4, 2), (4, 3)
    // these much function calls

    // SC -> O(m*n)
    // O(m*n) -> size of dp

    public int uniquePaths(int m, int n) {
        int[] prevDp = new int[n];

        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[0] = 1;
                    continue;
                }
                int up = 0, left = 0;
                if (i > 0) {
                    // up = dp[i - 1][j]; dp[i - 1] -> previous dp, so it is available in prevDp
                    // so directly write dp[i-1][j] -> j th col of rpevious row -> prevDp[j]
                    up = prevDp[j];
                }
                if (j > 0) {
                    left = temp[j - 1];
                }
                temp[j] = up + left;
            }
            prevDp = temp;
        }
        return prevDp[n - 1];
    }

    // Tabulation

    // TC -> O(m * n) // number of state // how many calls
    // (0, 0), (0, 1), (0, 2), (0, 3)
    // (1, 0), (1, 1), (1, 2), (1, 3)
    // (3, 0), (3, 1), (3, 2), (3, 3)
    // (4, 0), (4, 1), (4, 2), (4, 3)
    // these much function calls

    // SC -> O(m*n)
    // O(m*n) -> size of dp

    public int uniquePaths_(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                    continue;
                }
                int up = 0, left = 0;
                if (i > 0) {
                    up = dp[i - 1][j];
                }
                if (j > 0) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }

    // Memoization

    // TC -> O(m * n) // number of state // how many calls
    // (0, 0), (0, 1), (0, 2), (0, 3)
    // (1, 0), (1, 1), (1, 2), (1, 3)
    // (3, 0), (3, 1), (3, 2), (3, 3)
    // (4, 0), (4, 1), (4, 2), (4, 3)
    // these much function calls

    // SC -> O(path length) + O(m*n)
    // O((m-1) + (n-1)) + O(m*n)
    // O((m-1) + (n-1)) -> Recursive Statck Space
    // O(m*n) -> size of dp

    public int check__(int i, int j, int[][] dp) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = check__(i - 1, j, dp);
        int left = check__(i, j - 1, dp);

        return dp[i][j] = up + left;
    }

    public int uniquePaths__(int m, int n) {
        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return check__(m - 1, n - 1, dp);
    }

    // Recursive

    // TC -> O(2 ^ (m * n))
    // SC -> O(path length) -> O((m-1) + (n-1))

    public int check___(int i, int j) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        int up = check___(i - 1, j);
        int left = check___(i, j - 1);

        return up + left;
    }

    public int uniquePaths___(int m, int n) {
        return check___(m, n);
    }
}
