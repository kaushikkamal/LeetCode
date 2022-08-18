package LeetCode;

import java.util.Arrays;

public class CombinationSumIV {
    // public static int combinationSum4(int[] arr, int target) {

    // if (target == 0) {
    // return 1;
    // }

    // int res = 0;
    // for (int i = 0; i < arr.length; i++) {
    // if (target >= arr[i]) {
    // res += combinationSum4(arr, target - arr[i]);
    // }
    // }

    // return res;
    // }

    private static int[] dp;

    public static int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private static int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 3 };
        int target = 35;
        System.out.println(combinationSum4(arr, target));
    }
}
