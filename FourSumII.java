package LeetCode;

// https://leetcode.com/problems/4sum-ii/
import java.util.HashMap;

public class FourSumII {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int c = 0;

        for (Integer num1 : nums1) {
            for (Integer num2 : nums2) {
                map.put(num1 + num2, map.getOrDefault(num1 + num2, 0) + 1);
            }
        }

        for (Integer num3 : nums3) {
            for (Integer num4 : nums4) {
                if (map.containsKey(-(num3 + num4))) {
                    c += map.getOrDefault(-(num3 + num4), 0);
                }
            }
        }
        return c;
    }
}
