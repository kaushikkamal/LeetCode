// https://leetcode.com/problems/longest-consecutive-sequence/

package LeetCode;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int c = 1;
                int temp = num + 1;

                while (set.contains(temp)) {
                    temp++;
                    c++;
                }
                max = Math.max(max, c);
            }
        }
        return max;
    }
}
