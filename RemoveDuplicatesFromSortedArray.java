// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
package LeetCode;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int first = 0;
        int n = nums.length;

        for (int second = 1; second < n; second++) {
            if (nums[first] != nums[second]) {
                first++;
                nums[first] = nums[second];
            }
        }

        return first + 1;
    }
}
