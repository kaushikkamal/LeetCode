package LeetCode;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];


        // kadane algorithm

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            max = Math.max(sum, max);

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}
