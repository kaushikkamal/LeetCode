package LeetCode;

// https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {

        int[] sorted = new int[nums.length];
        int start = 0, end = nums.length - 1;

        for (int i = sorted.length - 1; i >= 0; i--) {
            if (Math.abs(nums[start]) > Math.abs(nums[end])) {
                sorted[i] = nums[start] * nums[start];
                start++;
            } else {
                sorted[i] = nums[end] * nums[end];
                end--;
            }
        }
        return sorted;
    }
}
