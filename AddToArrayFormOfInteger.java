// https://leetcode.com/problems/add-to-array-form-of-integer/

package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] nums, int k) {
        int n = nums.length;
        List<Integer> res = new LinkedList<>();

        for (int i = n - 1; i >= 0; i--) {
            res.add(0, (nums[i] + k) % 10);
            k = (nums[i] + k) / 10;
        }

        while (k > 0) {
            res.add(0, k % 10);
            k = k / 10;
        }

        return res;
    }
}
