// https://leetcode.com/problems/max-consecutive-ones-iii/

package LeetCode;

public class MaxConsecutiveOnes3 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxCount = 0;
        int swapped = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            if (nums[end] == 0) {
                swapped++;
            }
            if (swapped > k) {
                if (nums[start] == 0) {
                    swapped--;
                }
                start++;
            }
            if (swapped <= k) {
                maxCount = Math.max(maxCount, end - start + 1);
            }
        }
        return maxCount;
    }
}
