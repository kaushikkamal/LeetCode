// https://www.geeksforgeeks.org/problems/rod-cutting0840/1

package LeetCode;

import java.util.Arrays;

public class RodCutting {
    // Tabulation
    // TC -> O(N * N)
    // SC -> O(N * N)
    public int cutRod(int[] price) {
        // code here
        int N = price.length;
        int[][] dp = new int[N][N + 1];

        for (int rodLength = 0; rodLength <= N; rodLength++) {
            dp[0][rodLength] = rodLength * price[0];
        }

        for (int index = 1; index < N; index++) {
            for (int rodLength = 0; rodLength <= N; rodLength++) {
                int picked = 0;
                int notPicked = 0;
                int rodUsed = index + 1;

                if (rodUsed <= rodLength) {
                    picked = price[index] + dp[index][rodLength - rodUsed];
                }

                notPicked = dp[index - 1][rodLength];

                dp[index][rodLength] = Math.max(picked, notPicked);
            }
        }

        return dp[N - 1][N];
    }

    // Memoization
    // TC -> O(N * N)
    // SC -> O(N * N) + O(N)
    private int findMax(int index, int rodLength, int[] price, int[][] dp) {
        if (index == 0) {
            return rodLength * price[0];
        }

        if (dp[index][rodLength] != -1) {
            return dp[index][rodLength];
        }

        int picked = 0;
        int notPicked = 0;

        int rodUsed = index + 1;

        if (rodUsed <= rodLength) {
            picked = price[index] + findMax(index, rodLength - rodUsed, price, dp);
        }

        notPicked = findMax(index - 1, rodLength, price, dp);

        return dp[index][rodLength] = Math.max(picked, notPicked);
    }

    public int cutRod_(int[] price) {
        // code here
        int N = price.length;
        int[][] dp = new int[N][N + 1];

        for (int index = 0; index < N; index++) {
            Arrays.fill(dp[index], -1);
        }

        return findMax(N - 1, N, price, dp);
    }
}
