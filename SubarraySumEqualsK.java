// https://leetcode.com/problems/subarray-sum-equals-k/description/

package LeetCode;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
