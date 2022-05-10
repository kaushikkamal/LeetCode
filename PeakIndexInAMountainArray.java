package LeetCode;

// https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start != end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            }
        }
        return start;
    }
}