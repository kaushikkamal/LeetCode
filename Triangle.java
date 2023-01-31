// https://leetcode.com/problems/triangle/description/

package LeetCode;

import java.util.Arrays;
import java.util.List;

public class Triangle {

    // Space Optimized Tabulation
    // TC -> O(N * M)
    // SC -> O(M)

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(triangle.size() - 1).size();
        int[] prevDp = new int[m];

        for (int col = 0; col < m; col++) {
            prevDp[col] = triangle.get(n - 1).get(col);
        }

        for (int row = n - 2; row >= 0; row--) {
            int[] temp = prevDp.clone();
            for (int col = row; col >= 0; col--) {
                int down = prevDp[col];
                int diagonal = prevDp[col + 1];

                temp[col] = triangle.get(row).get(col) + Math.min(down, diagonal);
            }
            prevDp = temp;
        }

        return prevDp[0];
    }

    // Tabulation
    // TC -> O(N * M)
    // SC -> O(N * M)

    public int minimumTotal_(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[n][m];

        for (int col = 0; col < m; col++) {
            dp[n - 1][col] = triangle.get(n - 1).get(col);
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int col = row; col >= 0; col--) {
                int down = dp[row + 1][col];
                int diagonal = dp[row + 1][col + 1];

                dp[row][col] = triangle.get(row).get(col) + Math.min(down, diagonal);
            }
        }

        return dp[0][0];
    }

    // Memoization
    // TC -> O(N * M)
    // SC -> O(N) + O(N * M)

    private int count__(int row, int col, List<List<Integer>> triangle, int[][] dp) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int down = count__(row + 1, col, triangle, dp);
        int diagonal = count__(row + 1, col + 1, triangle, dp);

        dp[row][col] = triangle.get(row).get(col) + Math.min(down, diagonal);

        return dp[row][col];
    }

    public int minimumTotal__(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return count__(0, 0, triangle, dp);
    }

    // Recursion
    // TC -> O(2 ^ (1 + 2 + 3 + .... + M))
    // SC -> O(N)

    private int count___(int row, int col, List<List<Integer>> triangle) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        int down = count___(row + 1, col, triangle);
        int diagonal = count___(row + 1, col + 1, triangle);

        return triangle.get(row).get(col) + Math.min(down, diagonal);
    }

    public int minimumTotal___(List<List<Integer>> triangle) {
        return count___(0, 0, triangle);
    }
}
