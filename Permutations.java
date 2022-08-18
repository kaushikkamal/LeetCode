// https://leetcode.com/problems/permutations/

package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void solve(int[] nums, List<Integer> list, boolean[] check, List<List<Integer>> ans) {
        // base case

        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!check[i]) {
                check[i] = true;
                list.add(nums[i]);
                solve(nums, list, check, ans);
                list.remove(list.size() - 1);

                check[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] check = new boolean[nums.length];

        solve(nums, new ArrayList<>(), check, ans);

        return ans;
    }
}
