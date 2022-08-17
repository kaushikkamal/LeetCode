// https://leetcode.com/problems/subsets/
package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private static void subset(int[] nums, int i, List<Integer> list, List<List<Integer>> ans) {
        // base case
        if (i == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // picked
        list.add(nums[i]);
        subset(nums, i + 1, list, ans);
        list.remove(list.size() - 1);

        // not picked
        subset(nums, i + 1, list, ans);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subset(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> ans = subsets(nums);

        System.out.println(ans);
    }
}
