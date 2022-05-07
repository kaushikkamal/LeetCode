package LeetCode;

// https://leetcode.com/problems/majority-element-ii/
import java.util.*;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        if (nums.length == 1) {
            list.add(nums[0]);
            return list;
        }

        if (nums.length == 2) {
            list.add(nums[0]);
            if (!list.contains(nums[1])) {
                list.add(nums[1]);
            }
            return list;
        }

        int num1 = -1, num2 = -1, count1 = 0, count2 = 0;
        int limit = nums.length / 3;

        for (int val : nums) {
            if (val == num1) {
                count1++;
            } else if (val == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = val;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = val;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int val : nums) {
            if (val == num1) {
                count1++;
            } else if (val == num2) {
                count2++;
            }
        }

        if (count1 > limit) {
            list.add(num1);
        }
        if (count2 > limit) {
            if (!list.contains(num2)) {
                list.add(num2);
            }
        }
        return list;
    }
}
