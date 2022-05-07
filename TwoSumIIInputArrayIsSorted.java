package LeetCode;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                return new int[] { start + 1, end + 1 };
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[] { -1, -1 };
    }
}
