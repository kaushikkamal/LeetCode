package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        if (nums.length <= 2) {
            return list;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int start = i + 1;
                int end = nums.length - 1;

                while (start < end) {
                    if (nums[i] + nums[start] + nums[end] == 0) {
                        list.add(Arrays.asList(nums[i], nums[start], nums[end]));

                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        start++;

                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        end--;
                    } else if (nums[i] + nums[start] + nums[end] < 0) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return list;
    }
}
