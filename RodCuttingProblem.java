// https://www.codingninjas.com/codestudio/problems/rod-cutting-problem_800284

package LeetCode;

import java.util.Arrays;

public class RodCuttingProblem {
    // One Row Space Optimized Tabulation
    // TC -> O(N * N)
    // SC -> O(N)
    public static int cutRod(int price[], int N) {
        int[] prev = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            prev[i] = i * price[0];
        }

        for (int i = 1; i < N; i++) {
            for (int cutLength = 0; cutLength <= N; cutLength++) {
                int notPicked = 0, picked = 0;

                notPicked = prev[cutLength];

                int rodLength = i + 1;

                if (rodLength <= cutLength) {
                    picked = price[i] + prev[cutLength - rodLength];
                }

                prev[cutLength] = Math.max(picked, notPicked);
            }
        }
        return prev[N];
    }

    // Space Optimized Tabulation
    // TC -> O(N * N)
    // SC -> O(N)
    public static int cutRod_(int price[], int N) {
        int[] prev = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            prev[i] = i * price[0];
        }

        for (int i = 1; i < N; i++) {
            int[] cur = new int[N + 1];
            for (int cutLength = 0; cutLength <= N; cutLength++) {
                int notPicked = 0, picked = 0;

                notPicked = prev[cutLength];

                int rodLength = i + 1;

                if (rodLength <= cutLength) {
                    picked = price[i] + cur[cutLength - rodLength];
                }

                cur[cutLength] = Math.max(picked, notPicked);
            }
            prev = cur;
        }
        return prev[N];
    }

    // Tabulation
    // TC -> O(N * N)
    // SC -> O(N * N)
    public static int cutRod__(int price[], int N) {
        int[][] dp = new int[N][N + 1];

        for (int i = 0; i <= N; i++) {
            dp[0][i] = i * price[0];
        }

        for (int i = 1; i < N; i++) {
            for (int cutLength = 0; cutLength <= N; cutLength++) {
                int notPicked = 0, picked = 0;

                notPicked = dp[i - 1][cutLength];

                int rodLength = i + 1;

                if (rodLength <= cutLength) {
                    picked = price[i] + dp[i][cutLength - rodLength];
                }

                dp[i][cutLength] = Math.max(picked, notPicked);
            }
        }

        return dp[N - 1][N];
    }

    // Mempozation
    // TC -> O(N * N)
    // SC -> O(N * N) + O(N)
    private static int maxRodLength___(int index, int N, int[] price, int[][] dp) {
        if (index == 0) {
            return N * price[0];
        }

        if (dp[index][N] != -1) {
            return dp[index][N];
        }

        int notPicked = 0, picked = 0;

        notPicked = maxRodLength___(index - 1, N, price, dp);

        int rodLength = index + 1;

        if (rodLength <= N) {
            picked = price[index] + maxRodLength___(index, N - rodLength, price, dp);
        }

        dp[index][N] = Math.max(picked, notPicked);

        return dp[index][N];
    }

    public static int cutRod___(int price[], int n) {
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return maxRodLength___(n - 1, n, price, dp);
    }

    // Recursive
    // TC -> > O(2 ^ N) (exponential)
    // SC -> O(N)
    private static int maxRodLength____(int index, int N, int[] price) {
        if (index == 0) {
            return N * price[0];
        }

        int notPicked = 0, picked = 0;

        notPicked = maxRodLength____(index - 1, N, price);

        int rodLength = index + 1;

        if (rodLength <= N) {
            picked = price[index] + maxRodLength____(index, N - rodLength, price);
        }

        return Math.max(picked, notPicked);
    }

    public static int cutRod____(int price[], int n) {
        return maxRodLength____(n - 1, n, price);
    }
}
