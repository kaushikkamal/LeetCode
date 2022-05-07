package LeetCode;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int min = -1;
        int max = -1;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                min = mid;
                end = mid - 1;
            }
        }

        start = 0;
        end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                max = mid;
                start = mid + 1;
            }
        }

        res[0] = min;
        res[1] = max;
        return res;
    }
}
