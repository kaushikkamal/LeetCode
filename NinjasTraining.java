// https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003

package LeetCode;

import java.util.Arrays;

public class NinjasTraining {

    // Space Optimized Tabulation
    // TC -> O(N*4) * 3 = O(N*12)
    // SC -> O(4)

    public static int ninjaTraining(int n, int points[][]) {
        int[] prevDp = new int[4];

        prevDp[0] = Math.max(points[0][1], points[0][2]);
        prevDp[1] = Math.max(points[0][0], points[0][2]);
        prevDp[2] = Math.max(points[0][0], points[0][1]);
        prevDp[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + prevDp[task];
                        temp[last] = Math.max(temp[last], point);
                    }
                }
            }
            prevDp = temp;
        }
        return prevDp[3];
    }

    // Tabulation
    // TC -> O(N*4) * 3 = O(N*12)
    // SC -> O(N*4)

    public static int ninjaTraining_(int n, int points[][]) {
        int[][] dp = new int[n][4];

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }
        return dp[n - 1][3];
    }

    // Mempozation
    // TC -> O(N*4) * 3 = O(N*12)
    // SC -> O(N) + O(N*4)

    private static int findMaxMerit__(int day, int last, int[][] points, int[][] dp) {
        if (dp[day][last] != -1)
            return dp[day][last];

        if (day == 0) {
            int maxMerit = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxMerit = Math.max(maxMerit, points[day][task]);
                }
            }
            dp[day][last] = maxMerit;
            return maxMerit;
        }

        int maxMerit = 0;

        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[day][task] + findMaxMerit__(day - 1, task, points, dp);
                maxMerit = Math.max(maxMerit, point);
            }
        }

        dp[day][last] = maxMerit;

        return maxMerit;
    }

    public static int ninjaTraining__(int n, int points[][]) {
        int[][] dp = new int[n][4];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return findMaxMerit__(n - 1, 3, points, dp);
    }

    // Recursion

    private static int findMaxMerit___(int day, int last, int[][] points) {
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i < points[0].length; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, points[0][i]);
                }
            }
            return maxi;
        }

        int maxi = 0;
        for (int i = 0; i < points[0].length; i++) {
            if (i != last) {
                int point = points[day][i] + findMaxMerit___(day - 1, i, points);
                maxi = Math.max(maxi, point);
            }
        }
        return maxi;
    }

    public static int ninjaTraining___(int n, int points[][]) {
        return findMaxMerit___(n - 1, 3, points);
    }
}
