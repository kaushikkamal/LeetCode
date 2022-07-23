// https://leetcode.com/problems/single-element-in-a-sorted-array/submissions/

// TC -> O(log(N))
// SC -> O(1)

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || mid % 2 == 1 && nums[mid] == nums[mid - 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 3, 3, 4, 5, 5 };
        System.out.println(new SingleElementInASortedArray().singleNonDuplicate(nums));
    }
}
