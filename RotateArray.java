package LeetCode;

// https://leetcode.com/problems/rotate-array/
import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, nums.length);
        if (n == 1) {
            return;
        }
        if (k >= n) {
            k = k % n;
        }
        for (int i = 0; i < n; i++) {
            if (i < k) {
                nums[i] = temp[n - k + i];
            } else {
                nums[i] = temp[i - k];
            }
        }
    }
}
