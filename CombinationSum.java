// https://leetcode.com/problems/combination-sum/
package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private void combination(int[] candidates, int i, List<Integer> list, List<List<Integer>> ans, int target) {

        // base case
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (i == candidates.length) {
            return;
        }

        if (target >= candidates[i]) {
            list.add(candidates[i]);
            combination(candidates, i, list, ans, target - candidates[i]);
            list.remove(list.size() - 1);
        }

        combination(candidates, i + 1, list, ans, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        combination(candidates, 0, new ArrayList<>(), ans, target);

        return ans;
    }
}
