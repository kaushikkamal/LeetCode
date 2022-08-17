// https://leetcode.com/problems/combination-sum-iii/

package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    private void solve(int k, int total, int index, List<Integer> list, List<List<Integer>> ans) {
        // base case
        if (list.size() == k) {
            if (total == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if (index > 9) {
            return;
        }

        list.add(index);
        solve(k, total - index, index + 1, list, ans);
        list.remove(list.size() - 1);

        solve(k, total, index + 1, list, ans);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        solve(k, n, 1, list, ans);

        return ans;
    }
}
