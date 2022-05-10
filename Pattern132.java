package LeetCode;

import java.util.Stack;

// https://leetcode.com/problems/132-pattern/

public class Pattern132 {

    // TC -> O(n)
    // SC -> O(n)

    public static boolean find132pattern(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < max) {
                return true;
            }
            while (!s.isEmpty() && nums[i] > s.peek()) {
                max = s.pop();
            }
            s.push(nums[i]);
        }
        return false;
    }

    // TC -> O(n^2)
    // SC -> O(1)

    public static boolean find132pattern__(int[] nums) {
        int min = nums[0];
        for (int j = 0; j < nums.length - 1; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[j] > nums[k] && nums[k] > min) {
                    return true;
                }
                min = Math.min(min, nums[j]);
            }
        }
        return false;
    }

}