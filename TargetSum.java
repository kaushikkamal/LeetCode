// https://leetcode.com/problems/target-sum/

package LeetCode;

public class TargetSum {
    // Space Optimized Tabulation
    // TC -> O(N * sum)
    // SC -> O(sum)
    public int findWays(int arr[], int n, int sum) {
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

                curDp[target] = (picked + notPicked);
            }
            prevDp = curDp;
        }
        return prevDp[sum];
    }

    public int countPartitions(int n, int d, int[] arr) {
        int total = 0;

        for (int num : arr) {
            total += num;
        }

        if ((total - d) < 0 || (total - d) % 2 == 1) {
            return 0;
        }

        return findWays(arr, n, (total - d) / 2);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return countPartitions(n, target, nums);
    }

    // recursive

    private int solve(int[] nums, int index, int target, int count) {

        if (index == nums.length) {
            if (target == count) {
                return 1;
            }
            return 0;
        }

        // main logic

        int pos = solve(nums, index + 1, target, count + nums[index]);
        int neg = solve(nums, index + 1, target, count - nums[index]);

        return pos + neg;
    }

    public int findTargetSumWays_(int[] nums, int target) {
        return solve(nums, 0, target, 0);
    }
}
