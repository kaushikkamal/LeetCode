// https://leetcode.com/problems/4sum/
package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        if (n <= 3 || nums == null) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int sum = target - nums[i] - nums[j];

                int start = j + 1;
                int end = n - 1;

                while (start < end) {
                    int twoSum = nums[start] + nums[end];

                    if (twoSum < sum) {
                        start++;
                    } else if (twoSum > sum) {
                        end--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));

                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        start++;

                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        end--;
                    }
                }
                while (j + 1 < n && nums[j] == nums[j + 1]) {
                    ++j;
                }
            }
            while (i + 1 < n && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
        return res;
    }
}