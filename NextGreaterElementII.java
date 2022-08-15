// https://leetcode.com/problems/next-greater-element-ii/

package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> s = new ArrayDeque<>();

        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && nums[i % nums.length] >= nums[s.peek()]) {
                s.pop();
            }

            res[i % nums.length] = s.isEmpty() ? -1 : nums[s.peek()];
            s.push(i % nums.length);
        }
        return res;
    }
}
