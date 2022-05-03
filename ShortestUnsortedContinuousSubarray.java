package LeetCode;

// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    // public int findUnsortedSubarray(int[] nums) {
    // int start = nums.length;
    // int end = 0;

    // for (int i = 0; i < nums.length - 1; i++) {
    // for (int j = i + 1; j < nums.length; j++) {
    // if (nums[j] < nums[i]) {
    // start = Math.min(start, i);
    // end = Math.max(end, j);
    // }
    // }
    // }

    // return end - start > 0 ? end - start + 1 : 0;
    // }
    public int findUnsortedSubarray(int[] nums) {
        int start = nums.length;
        int end = 0;
        int[] sorted = nums.clone();

        Arrays.sort(sorted);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sorted[i]) {
                start = Math.min(start, i);
                end = Math.max(start, i);
            }
        }
        return end - start > 0 ? end - start + 1 : 0;
    }
}
