package LeetCode;

import java.util.HashMap;

public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    // O(N^2)

    // int[] res = new int[2];
    // for (int i = 0; i < nums.length - 1; i++) {
    // for (int j = i + 1; j < nums.length; j++) {
    // if (nums[i] + nums[j] == target) {
    // res[0] = i;
    // res[1] = j;
    // return res;
    // }
    // }
    // }
    // return res;

    // O(N)

    int[] res = new int[2];
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        res[1] = i;
        res[0] = map.get(target - nums[i]);

        return res;
      }
      map.put(nums[i], i);
    }

    return res;
  }
}
