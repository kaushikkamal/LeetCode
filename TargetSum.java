// https://leetcode.com/problems/target-sum/

package LeetCode;

public class TargetSum {
    private int solve(int[] nums, int index, int target, int count) {
        // base case

        if (index == nums.length) {
            if (target == count) {
                return 1;
            }
            return 0;
        }

        // main logic

        return solve(nums, index + 1, target, count + nums[index])
                + solve(nums, index + 1, target, count - nums[index]);
    }

    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, target, 0);
    }
}
