// https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/

package LeetCode;

import java.util.HashMap;

public class CountNumberOfPairsWithAbsoluteDifferenceK {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                res += map.get(nums[i] - k);
            }
            if (map.containsKey(nums[i] + k)) {
                res += map.get(nums[i] + k);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return res;
    }
}
