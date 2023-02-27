// https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

package LeetCode;

import java.util.Arrays;

class SubsetSumEqualToK {
    // Space Optimized Tabulation
    // TC -> O(N * target)
    // SC -> O(target)
    public boolean subsetSumToK(int n, int k, int arr[]) {
        boolean[] prevDp = new boolean[k + 1];

        prevDp[0] = true;
        if (arr[0] < k) {
            prevDp[arr[0]] = true;
        }

        for (int index = 1; index < n; index++) {
            boolean[] curDp = new boolean[k + 1];
            curDp[0] = true; // target is 0, so true
            for (int target = 1; target <= k; target++) {
                boolean picked = false;
                boolean notPicked = false;

                if (target >= arr[index]) {
                    picked = prevDp[target - arr[index]];
                }

                notPicked = prevDp[target];

                curDp[target] = picked | notPicked;
            }
            prevDp = curDp;
        }

        return prevDp[k];
    }

    // Tabulation
    // TC -> O(N * target)
    // SC -> O(N * target)
    public boolean subsetSumToK_(int n, int k, int arr[]) {
        boolean[][] dp = new boolean[n][k + 1];

        for (int index = 0; index < n; index++) {
            dp[index][0] = true;
        }
        if (arr[0] < k) {
            dp[0][arr[0]] = true;
        }

        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= k; target++) {
                boolean picked = false;
                boolean notPicked = false;

                if (target >= arr[index]) {
                    picked = dp[index - 1][target - arr[index]];
                }

                notPicked = dp[index - 1][target];

                dp[index][target] = picked | notPicked;
            }
        }

        return dp[n - 1][k];
    }
    // Mempozation
    // TC -> O(N * target)
    // SC -> O(N * target) + O(N)

    private static boolean check__(int index, int[] arr, int target, boolean[][] dp) {
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return arr[index] == target;
        }

        if (dp[index][target]) {
            return dp[index][target];
        }

        boolean picked = false;
        boolean notPicked = false;

        if (target >= arr[index]) {
            picked = check__(index - 1, arr, target - arr[index], dp);
        }

        if (picked) {
            return true;
        }

        notPicked = check__(index - 1, arr, target, dp);

        dp[index][target] = picked | notPicked;

        return dp[index][target];
    }

    public static boolean subsetSumToK__(int n, int k, int arr[]) {
        boolean[][] dp = new boolean[n][k + 1];
        for (boolean[] row : dp) {
            Arrays.fill(row, false);
        }
        return check__(n - 1, arr, k, dp);
    }

    // Recursive
    // TC -> O(2 ^ N)
    // SC -> O(N)

    private static boolean check___(int index, int[] arr, int target) {
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return arr[index] == target;
        }

        boolean picked = false;
        boolean notPicked = false;

        if (target >= arr[index]) {
            picked = check___(index - 1, arr, target - arr[index]);
        }

        if (picked) {
            return true;
        }

        notPicked = check___(index - 1, arr, target);

        return picked | notPicked;
    }

    public static boolean subsetSumToK___(int n, int k, int arr[]) {
        return check___(n - 1, arr, k);
    }
}