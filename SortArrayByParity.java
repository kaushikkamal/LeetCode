package LeetCode;

// https://leetcode.com/problems/sort-array-by-parity/

public class SortArrayByParity {
    private static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    public int[] sortArrayByParity(int[] nums) {
        int i, j;
        i = 0;
        j = nums.length - 1;

        while (i < j) {
            if (!isEven(nums[i]) && isEven(nums[j])) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
                j--;
            }

            if (isEven(nums[i])) {
                i++;
            }
            if (!isEven(nums[j])) {
                j--;
            }
        }
        return nums;
    }
}
