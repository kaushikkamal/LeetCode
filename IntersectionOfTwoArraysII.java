package LeetCode;

// https://leetcode.com/problems/intersection-of-two-arrays-ii/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mp = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : nums1) {
            if (mp.containsKey(i)) {
                mp.put(i, mp.get(i) + 1);
            } else {
                mp.put(i, 1);
            }
        }

        for (int i : nums2) {
            if (mp.containsKey(i) && mp.get(i) != 0) {
                list.add(i);
                mp.put(i, mp.get(i) - 1);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
