package LeetCode;

// https://leetcode.com/problems/3sum-closest/
import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int maxSum = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int start = i + 1;
                int end = nums.length - 1;

                while (start < end) {
                    int sum = nums[i] + nums[start] + nums[end];

                    if (sum == target) {
                        return target;
                    }

                    if (Math.abs(target - sum) < Math.abs(target - maxSum)) {
                        maxSum = sum;
                    }

                    if (sum < target) {
                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        start++;
                    } else {
                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        end--;
                    }
                }
            }
        }
        return maxSum;
    }
}
