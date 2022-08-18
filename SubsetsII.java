// https://leetcode.com/problems/subsets-ii/

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    private void subset(int[] nums, int index, List<Integer> list, List<List<Integer>> ans) {
        // base case
        ans.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            subset(nums, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        subset(nums, 0, new ArrayList<>(), ans);

        return ans;
    }
}
