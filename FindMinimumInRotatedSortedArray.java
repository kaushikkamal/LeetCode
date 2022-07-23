// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

// TC -> O(log(n))
// SC -> O()

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int N = nums.length;

        int start = 0;
        int end = N - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid == 0) {
                return Math.min(nums[0], nums[1]);
            } else if (mid == N - 1) {
                return Math.min(nums[N], nums[N - 1]);
            } else {

                if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                    return nums[mid];
                } else if (nums[mid] < nums[end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }
        return -1;
    }

}
