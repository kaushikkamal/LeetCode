// https://leetcode.com/problems/max-consecutive-ones/
package LeetCode;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int total = 0;
        int one = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                one++;
                total = Math.max(total, one);
            } else {
                one = 0;
            }
        }
        return total;
    }
}
