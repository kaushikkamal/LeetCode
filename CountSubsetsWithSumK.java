// https://www.codingninjas.com/codestudio/problems/number-of-subsets_3952532

package LeetCode;

import java.util.Arrays;

public class CountSubsetsWithSumK {
    // Space Optimized Tabulation
    // TC -> O(N * sum)
    // SC -> O(sum)

    public int perfectSum(int arr[], int n, int sum) {
        int[] prevDp = new int[sum + 1];

        if (arr[0] == 0) {
            prevDp[0] = 2;
        } else {
            prevDp[0] = 1;
        }

        if (arr[0] != 0 && arr[0] <= sum) {
            prevDp[arr[0]] = 1;
        }

        for (int index = 1; index < n; index++) {
            int[] curDp = new int[sum + 1];
            if (arr[0] != 0 && arr[0] <= sum) {
                curDp[arr[0]] = 1;
            }
            for (int target = 0; target <= sum; target++) {
                int picked = 0, notPicked = 0;

                if (target >= arr[index]) {
                    picked = prevDp[target - arr[index]];
                }

                notPicked = prevDp[target];

                curDp[target] = picked + notPicked;
            }
            prevDp = curDp;
        }
        return prevDp[sum];
    }

    // Tabulation
    // TC -> O(N * sum)
    // SC -> O(N * sum)

    public int perfectSum_(int arr[], int n, int sum) {
        int[][] dp = new int[n][sum + 1];

        if (arr[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
        }

        if (arr[0] != 0 && arr[0] <= sum) {
            dp[0][arr[0]] = 1;
        }

        for (int index = 1; index < n; index++) {
            for (int target = 0; target <= sum; target++) {
                int picked = 0, notPicked = 0;

                if (target >= arr[index]) {
                    picked = dp[index - 1][target - arr[index]];
                }

                notPicked = dp[index - 1][target];

                dp[index][target] = picked + notPicked;
            }
        }
        return dp[n - 1][sum];
    }

    // Mempozation
    // TC -> O(N * sum)
    // SC -> O(N * sum) + O(N)

    private int f__(int index, int target, int[] nums, int[][] dp) {
        // let it travel to the last index
        if (index == 0) {
            if (target == 0 && nums[0] == 0)
                return 2;
            if (target == 0 || nums[0] == target)
                return 1;
            return 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int picked = 0, notPicked = 0;

        if (target >= nums[index]) {
            picked = f__(index - 1, target - nums[index], nums, dp);
        }

        notPicked = f__(index - 1, target, nums, dp);

        dp[index][target] = picked + notPicked;
        return dp[index][target];
    }

    public int perfectSum__(int nums[], int n, int target) {
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f__(n - 1, target, nums, dp);
    }
}
