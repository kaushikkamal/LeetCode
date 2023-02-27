// https://leetcode.com/problems/partition-equal-subset-sum/description/

package LeetCode;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    // Space Optimized Tabulation
    // TC -> O(N * target)
    // SC -> O(target)
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int newSum = sum / 2;

        boolean[] prevDp = new boolean[sum + 1];

        prevDp[0] = true;
        if (nums[0] < sum) {
            prevDp[nums[0]] = true;
        }

        for (int index = 1; index < n; index++) {
            boolean[] curDp = new boolean[sum + 1];
            curDp[0] = true;
            for (int target = 1; target <= newSum; target++) {
                boolean picked = false, notPicked = false;

                if (target >= nums[index]) {
                    picked = prevDp[target - nums[index]];
                }

                notPicked = prevDp[target];

                curDp[target] = picked | notPicked;
            }
            prevDp = curDp;
        }

        return prevDp[newSum];
    }

    // Tabulation
    // TC -> O(N * target)
    // SC -> O(N * target)
    public boolean canPartition_(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        boolean[][] dp = new boolean[n][sum + 1];
        int newSum = sum / 2;

        for (int index = 0; index < n; index++) {
            dp[index][0] = true;
        }
        if (nums[0] < sum) {
            dp[0][nums[0]] = true;
        }

        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= newSum; target++) {
                boolean picked = false, notPicked = false;

                if (target >= nums[index]) {
                    picked = dp[index - 1][target - nums[index]];
                }

                notPicked = dp[index - 1][target];

                dp[index][target] = picked | notPicked;
            }
        }

        return dp[n - 1][newSum];
    }
    // Mempozation
    // TC -> O(N * target)
    // SC -> O(N * target) + O(N)

    private boolean subsetSum__(int index, int target, int[] nums, boolean[][] dp) {
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return nums[index] == target;
        }

        if (dp[index][target]) {
            return true;
        }

        boolean picked = false, notPicked = false;

        if (target >= nums[index]) {
            picked = subsetSum__(index - 1, target - nums[index], nums, dp);
        }

        notPicked = subsetSum__(index - 1, target, nums, dp);

        dp[index][target] = picked | notPicked;
        return dp[index][target];
    }

    public boolean canPartition__(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        boolean[][] dp = new boolean[n][sum + 1];
        int newSum = sum / 2;

        for (boolean[] row : dp) {
            Arrays.fill(row, false);
        }

        return subsetSum__(n - 1, newSum, nums, dp);
    }

    // Recursive
    // TC -> O(2 ^ N)
    // SC -> O(N)
    private boolean subsetSum___(int index, int target, int[] nums) {
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return nums[index] == target;
        }

        boolean picked = false, notPicked = false;

        if (target >= nums[index]) {
            picked = subsetSum___(index - 1, target - nums[index], nums);
        }

        notPicked = subsetSum___(index - 1, target, nums);

        return picked | notPicked;
    }

    public boolean canPartition___(int[] nums) {
        int n = nums.length;
        int target = 0;

        for (int num : nums) {
            target += num;
        }

        if ((target & 1) == 1) {
            return false;
        }

        target = target / 2;

        return subsetSum___(n - 1, target, nums);
    }
}
