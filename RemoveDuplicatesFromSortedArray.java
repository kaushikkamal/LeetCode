package LeetCode;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int j = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[j] = nums[i];
                j++;
            }
        }

        nums[j] = nums[nums.length - 1];
        j++;

        return j;
    }
}
