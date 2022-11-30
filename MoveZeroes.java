// https://leetcode.com/problems/move-zeroes/

package LeetCode;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int first = 0;
        int n = nums.length;

        for (int second = 0; second < n; second++) {
            if (nums[second] != 0) {
                nums[first] = nums[second];
                first++;
            }
        }

        while (first < n) {
            nums[first] = 0;
            first++;
        }
    }
}
